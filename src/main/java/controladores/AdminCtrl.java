package controladores;

import modelos.Lote;
import modelos.Puja;
import modelos.Subasta;
import spark.ModelAndView;
import spark.Request;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminCtrl {

    public static ModelAndView subirLote(Request req){

        /**
         * Recoger la imagen seleccionada y meterla en "/resources/public/image"
         */
        String location = "image";          // the directory location where files will be stored
        long maxFileSize = 100000000;       // the maximum size allowed for uploaded files
        long maxRequestSize = 100000000;    // the maximum size allowed for multipart/form-data requests
        int fileSizeThreshold = 1024;       // the size threshold after which files will be written to disk

        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
                location, maxFileSize, maxRequestSize, fileSizeThreshold);
        req.raw().setAttribute("org.eclipse.jetty.multipartConfig",
                multipartConfigElement);

        try {

            String fName = null;
            fName = req.raw().getPart("foto").getSubmittedFileName();

            System.out.println("File: " + fName);

            Part uploadedFile = null;
            uploadedFile = req.raw().getPart("foto");

            Path out = Paths.get("src/main/resources/public/image/"+fName);
            InputStream in = null;
            in = uploadedFile.getInputStream();

            Files.copy(in, out);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        /**
         * Recogemos la informacion del formulario y creamos un objeto lote con la info
         * Además, creamos un objeto subasta con el ID recogido del campo hidden del forumario
         * para poder asociar el lote creado a dicha subasta.
         *
         * En la BBDD buscaremos la subasta mediante el ID mencionado y añadiremos el lote.
         */
        Map<String, Object> model = new HashMap<>();
        ArrayList<Puja> pujas = new ArrayList<>();  //Sin pujas, objeto vacio.

        Lote lote = new Lote(req.queryParams("lote"), req.queryParams("valor"), Integer.parseInt(req.queryParams("anio")),
                req.queryParams("lugar"), req.queryParams("fecha"), req.queryParams("serie"), Integer.parseInt(req.queryParams("conservacion")),
                Integer.parseInt(req.queryParams("precio")), pujas);

        Lote [] lotes = new Lote[1];
        lotes[0] = lote;

        int idSubasta = Integer.parseInt(req.queryParams("id"));    //Recojo id de la subasta del formulario <input type=hidden>
        Subasta subasta = new Subasta(idSubasta, "Subasta X", lotes);

        subasta.uploadToBBDD();     //Carga los datos en la BBDD ---- COMPLETAR METODO
        subasta.downloadFromBBDD(); //Recoger datos de la subasta completa de la BBDD para mostrar los lotes que contiene. ---- COMPLETAR METODO

        model.put("subasta", subasta);
        return new ModelAndView(model, "templates/admin/lista_lotes.htm");
    }


    public static ModelAndView mostrarFormLote(Request req){

        /**
         * Conexion BBDD para obtener los datos de la subasta con el ID anterior.
         */

        int id = Integer.parseInt(req.params("id"));

        //Creamos una subasta con el ID
        Subasta subasta = new Subasta(id);

        //Descargamos los datos de la BBDD en el objeto creado mediante una consulta con el ID.
        subasta.downloadFromBBDD();

        Map<String, Object> model = new HashMap<>();
        model.put("subasta", subasta);

        return new ModelAndView(model, "templates/admin/subir_lote.htm");
    }

    public static ModelAndView mostrarListaLotes(Request req){
        int idSubasta = Integer.parseInt(req.params("id"));

        /**
         * Recoger datos sobre la subasta desde la base de datos mediante el ID.
         * Mostrar todos los lotes de la misma:
         */

        Subasta subasta = new Subasta(idSubasta, "Billetes de 100€");
        Map<String, Object> model = new HashMap<>();

        model.put("subasta", subasta);

        return new ModelAndView(model, "templates/admin/lista_lotes.htm");

    }

    public static ModelAndView mostrarListaSubastas(Request req){

        /**
         * Recoger listado de subastas y mostrarlo en array "subastas"
         *
         * Primero, consultar numero de subastas totales.
         * Segundo, crear un array de subastas con el numero obtenido.
         */

        Subasta subasta = new Subasta("subasta de la base d datos");
        Subasta [] subastas = new Subasta[1];

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);

        //Mostramos el listado de subastas actualizado.
        return new ModelAndView(model, "templates/admin/lista_subastas.htm");
    }

    public static ModelAndView deleteSubasta(Request req){

        /**
         * 1) Borrar la subasta de la base de datos, mediante el ID obtenido.
         *
         * 2) Recoger listado de subastas y mostrarlo en array "subastas". Igual que en "mostrarListaSubastas()"
         */

        int id = Integer.parseInt(req.params("id"));
        Subasta subastaBorrar = new Subasta(id);
        subastaBorrar.borrar();     //Borrar subasta de la BBDD mediante el ID. ---- COMPLETAR METODO

        Subasta subasta = new Subasta("subasta recogida de la base de datos");
        Subasta [] subastas = new Subasta[1];

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);

        //Mostramos estos mensajes de control, dependiendo si se ha borrado bien o no la subasta.
        model.put("error", "Datos incorrectos.");
        model.put("success", "Lote subido correctamente.");

        //Mostramos de nuevo el listado de subastas actualizadas.
        return new ModelAndView(model, "templates/admin/lista_subastas.htm");
    }

    public static ModelAndView editSubasta(Request req){

        /**
         * Buscar en la BBDD los datos de la subasta por el ID y mostrar el nombre en el campo text.
         */

        int id = Integer.parseInt(req.params("id"));

        Subasta subasta = new Subasta(id);
        subasta.downloadFromBBDD();     //Recoger datos de la BBDD mediante el ID. --- COMPLETAR METODO

        Map<String, Object> model = new HashMap<>();
        model.put("subasta", subasta);

        //Mostramos formulario para editar campo de subasta
        return new ModelAndView(model, "templates/admin/edit_subasta.htm");
    }

    public static ModelAndView updateSubasta(Request req){

        /**
         * Buscar en la BBDD los datos de la subasta por ID y actualizarla con los datos recogidos.
         * Tenemos titulo de subasta cambiado, actualizamos en la BBDD.
         */

        /*
         * Recoger listado de subastas y mostrarlo en array "subastas". Igual que en "mostrarListaSubastas()" y en "deleteSubasta()"
         * */

        int id = Integer.parseInt(req.queryParams("id"));
        String titulo = req.queryParams("subasta");

        Subasta subasta = new Subasta(id, titulo);
        subasta.updateToBBDD();     //Actualizar la subasta en la BBDD con los datos recogidos del formulario. ---- COMPLETAR METODO.

        Subasta [] subastas = new Subasta[1];

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);

        //Mostramos estos mensajes de control, dependiendo si se ha actualizado bien o no la subasta.
        model.put("error", "Datos incorrectos.");
        model.put("success", "Lote subido correctamente.");

        //Mostramos de nuevo el listado de subastas actualizadas.
        return new ModelAndView(model, "templates/admin/lista_subastas.htm");
    }

    public static ModelAndView subirSubasta(Request req){

        /**
         * Recogemos el titulo de la subasta del formulario anterior
         * Creamos un objeto de tipo subasta y llamamos la metodo que inserta en la BBDD una nueva subasta.
         */

        String titulo = req.queryParams("subasta");
        Subasta subasta = new Subasta(titulo);

        subasta.uploadToBBDD();     //Conexion con BBDD para guardar la subasta. ----- COMPLETAR METODO.


        Map<String, Object> model = new HashMap<>();

        //Mostramos estos mensajes de control, dependiendo si se ha insertado bien o no la subasta.
        //model.put("error", "Datos incorrectos.");
        //model.put("success", "Lote subido correctamente.");

        return new ModelAndView(model, "templates/admin/lista_subastas.htm");
    }

    public static ModelAndView mostrarFormSubasta(Request req){

        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "templates/admin/subir_subasta.htm");
    }

}

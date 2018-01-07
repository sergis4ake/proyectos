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

        Map<String, Object> model = new HashMap<>();
        ArrayList<Puja> pujas = new ArrayList<>();

        Lote lote = new Lote(req.queryParams("lote"), req.queryParams("valor"), Integer.parseInt(req.queryParams("anio")),
                req.queryParams("lugar"), req.queryParams("fecha"), req.queryParams("serie"), Integer.parseInt(req.queryParams("conservacion")),
                Integer.parseInt(req.queryParams("precio")), pujas);

        lote.loadToBBDD();  //Carga los datos en la BBDD ---- COMPLETAR

        model.put("error", "Datos incorrectos.");
        model.put("success", "Lote subido correctamente.");

        return new ModelAndView(model, "templates/admin/form_lote.htm");
    }


    public static ModelAndView mostrarFormLote(Request req){
        /**
         * Conexion BBDD para obtener IDs de las subastas y nombres.
         */
        // Consulta a la base de datos con el numero de subastas.
        int numSubastas = 1;

        // Rellenamos el array de subastas obteniendo lo datos de la BBDD.
        Subasta [] subastas = new Subasta[numSubastas];

        //Prueba.
        subastas[0] = new Subasta(1, "Monedas de 1€"); //Prueba.

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);

        return new ModelAndView(model, "templates/admin/form_lote.htm");
    }


    public static ModelAndView subirSubasta(Request req){

        Subasta subasta = new Subasta(req.queryParams("subasta"));

        //Conectar con BBDD para guardar la subasta.

        Map<String, Object> model = new HashMap<>();
        model.put("error", "Datos incorrectos.");
        model.put("success", "Lote subido correctamente.");

        return new ModelAndView(model, "templates/admin/form_subasta.htm");
    }

    public static ModelAndView mostrarFormSubasta(Request req){

        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "templates/admin/form_subasta.htm");
    }

    public static ModelAndView mostrarListaSubastas(Request req){

        /**
         * Recoger listado de subastas y mostrarlo en array "subastas"
         */

        Subasta subasta = new Subasta("subasta de la base d datos");
        Subasta [] subastas = new Subasta[1];

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);
        return new ModelAndView(model, "templates/admin/lista_subastas.htm");
    }

    public static ModelAndView editSubasta(Request req){

        String id = req.params("id");

        /**
         * Buscar en la BBDD los datos de la subasta seleccionada para mostrarla en el value del input text.
         */

        Subasta [] subastas = new Subasta[1];
        subastas[0] = new Subasta("subasta para editar");

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);
        return new ModelAndView(model, "templates/admin/edit_subasta.htm");
    }
    public static ModelAndView deleteSubasta(Request req){

        String id = req.params("id");

        /**
         * Borrar la subasta de la base de datos.
         * Recoger listado de subastas y mostrarlo en array "subastas"
         */

        Subasta subasta = new Subasta("subasta de la base d datos");
        Subasta [] subastas = new Subasta[1];

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);
        return new ModelAndView(model, "templates/admin/lista_subastas.htm");
    }



}

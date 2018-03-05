package controladores;

import dao.LoteDao;
import dao.SubastaDao;
import modelos.Lote;
import modelos.Puja;
import modelos.Subasta;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AdminLoteCtrl {

    public static LoteDao loteDao = new LoteDao();
    public static SubastaDao subastaDao = new SubastaDao();


    public static ModelAndView mostrarListaLotes(Request req){

        ArrayList<Lote> lotes = loteDao.selectAll();
        Map<String, Object> model = new HashMap<>();
        model.put("lotes", lotes);

        return new ModelAndView(model, "templates/admin/lotes/lista_lotes.htm");

    }

    public static ModelAndView mostrarFormLote(Request req){

        /**
         * Conexion BBDD para obtener los datos de la subasta con el ID anterior.
         */
        ArrayList<Subasta> subastas = subastaDao.selectAll();

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);

        return new ModelAndView(model, "templates/admin/lotes/subir_lote.htm");
    }

    public static ModelAndView deleteLote(Request req, Response res) {

        //Se recoge el ID de la subasta, y se utiliza el metodo para eliminarla.
        int idLote = Integer.parseInt(req.params("id"));
        loteDao.eliminar(idLote);

        res.redirect("/listaLotes");

        return null;
    }

    public static ModelAndView subirLote(Request req, Response res) {

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

        Lote l = new Lote();
        l.setIdSubasta(Integer.parseInt(req.queryParams("subasta")));
        l.setAnno(Integer.parseInt(req.queryParams("anno")));
        l.setConservacion(req.queryParams("conservacion"));
        l.setEstrellas(req.queryParams("estrellas"));
        l.setFechaLote(new Date(req.queryParams("fechaLote")));
        l.setPrecio(Double.parseDouble(req.queryParams("precio")));
        l.setSerie(req.queryParams("serie"));
        l.setTipo(req.queryParams("tipo"));
        l.setValor(req.queryParams("valor"));
        //l.setFoto(req.queryParams("foto"));

        loteDao.insertar(l);

        res.redirect("/listaLotes");

        return null;
    }


}

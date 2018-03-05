package controladores;

import modelos.Subasta;
import dao.SubastaDao;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AdminSubastaCtrl {

    public static SubastaDao subastaDao = new SubastaDao();

    public static ModelAndView mostrarGestionWeb(Request req){

        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "templates/admin/gestion_web.htm");
    }


    public static ModelAndView mostrarListaSubastas(Request req){

        ArrayList<Subasta> subastas = subastaDao.selectAll();

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);

        //Mostramos el listado de subastas actualizado.
        return new ModelAndView(model, "templates/admin/subastas/lista_subastas.htm");
    }

    public static ModelAndView mostrarFormSubasta(Request req){

        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "templates/admin/subastas/subir_subasta.htm");
    }


    public static ModelAndView subirSubasta(Request req, Response res){

        Subasta s = new Subasta();
        s.setFinalizacion(new Date(req.queryParams("finalizacion")));
        s.setTitulo(req.queryParams("titulo"));
        subastaDao.insertar(s);

        res.redirect("/listaSubastas");

        return null;

    }
    public static ModelAndView deleteSubasta(Request req, Response res) {

        //Se recoge el ID de la subasta, y se utiliza el metodo para eliminarla.
        int idSubasta = Integer.parseInt(req.params("id"));
        subastaDao.eliminar(idSubasta);

        res.redirect("/listaSubastas");

        return null;
    }

    public static ModelAndView editSubasta(Request req){

        int idSubasta = Integer.parseInt(req.params("id"));

        Subasta s = subastaDao.select(idSubasta);

        Map<String, Object> model = new HashMap<>();
        model.put("subasta", s);

        //Mostramos formulario para editar campo de subasta
        return new ModelAndView(model, "templates/admin/subastas/edit_subasta.htm");
    }

    public static ModelAndView updateSubasta(Request req, Response res) throws ParseException {

        Subasta s = new Subasta();
        Date fin = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String finStr = req.queryParams("finalizacion");
        fin = df.parse(finStr);

        s.setIdSubasta(Integer.parseInt(req.queryParams("id")));
        s.setTitulo(req.queryParams("titulo"));
        s.setFinalizacion(fin);
        subastaDao.actualizar(s);

        res.redirect("/listaSubastas");

        return null;

    }
}


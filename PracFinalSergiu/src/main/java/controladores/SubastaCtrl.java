package controladores;

import dao.LoteDao;
import dao.SubastaDao;
import dao.PujaDao;
import modelos.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SubastaCtrl {

    public static SubastaDao subastaDao = new SubastaDao();
    public static LoteDao loteDao = new LoteDao();
    public static PujaDao pujaDao = new PujaDao();

    public static ModelAndView mostrarSubastas(Request req){


        ArrayList<Subasta> subastas = subastaDao.selectAll();
        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);

        return new ModelAndView(model, "templates/subastas/lista_subastas.htm");
    }


    public static ModelAndView mostrarLotesSubasta(Request req){

        //////////////FALTA MOSTRAR LAS ULTIMAS PUJAS


        int idSubasta = Integer.parseInt(req.params("id"));
        Subasta s = subastaDao.select(idSubasta);
        Map<String, Object> model = new HashMap<>();
        model.put("subasta", s);

        return new ModelAndView(model, "templates/subastas/lista_lotes.htm");

    }

    public static ModelAndView pujarLote(Request req, Response res) {

        Map<String, Object> model = new HashMap<>();


        int importe = Integer.parseInt(req.queryParams("importe"));
        int idLote = Integer.parseInt(req.queryParams("idLote"));
        String email = req.session().attribute("email");

        Puja p = new Puja();
        p.setEmail(email);
        p.setIdLote(idLote);
        p.setImporte(importe);
        p.setFecha(new Date());

        pujaDao.insertar(p);

        Lote l = loteDao.select(idLote);
        res.redirect("/subasta" + l.getIdSubasta());

        return null;
    }
}

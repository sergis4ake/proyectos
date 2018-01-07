package controladores;

import modelos.Subasta;
import modelos.Lote;
import modelos.Puja;
import org.apache.commons.lang.ArrayUtils;
import spark.ModelAndView;
import spark.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubastaCtrl {
    public static ModelAndView mostrarSubastas(Request req){

        Puja puja = new Puja(1, 333, 1);
        Puja puja2 = new Puja(3, 111, 3);
        ArrayList<Puja> pujas = new ArrayList<>();
        pujas.add(puja);
        pujas.add(puja2);

        Lote[] lotes = new Lote[5];
        lotes[0] = new Lote(1, "Billetes de 100€", 100, pujas);
        lotes[1] = new Lote(2, "Moneda de 1€", 120, pujas);
        lotes[2] = new Lote(3, "Moneda de 50 cent", 130, pujas);
        lotes[3] = new Lote(4, "Moneda de 2€", 140, pujas);
        lotes[4] = new Lote(5, "Moneda de 20 cent", 150, pujas);

        Subasta[] subastas = new Subasta[5];
        subastas[0] = new Subasta(1, "Billetes de 100€", lotes);
        subastas[1] = new Subasta(2, "Moneda de 1€", lotes);
        subastas[2] = new Subasta(3, "Moneda de 50 cent");
        subastas[3] = new Subasta(4, "Moneda de 2€");
        subastas[4] = new Subasta(5, "Moneda de 20 cent");

        Map<String, Object> model = new HashMap<>();
        model.put("subastas", subastas);

        return new ModelAndView(model, "templates/subastas/lista_subastas.htm");
    }
    public static ModelAndView mostrarSubasta(Request req){
        String idSubasta = req.params("id");

        /**
         * Recoger datos sobre la subasta desde la base de datos mediante el ID.
         */

        Puja puja = new Puja(1, 333, 1);
        Puja puja2 = new Puja(3, 111, 3);
        ArrayList<Puja> pujas = new ArrayList<>();
        pujas.add(puja);
        pujas.add(puja2);

        Lote[] lotes = new Lote[5];
        lotes[0] = new Lote(1, "Billetes de 100€", 100, pujas);
        lotes[1] = new Lote(2, "Moneda de 1€", 120, pujas);
        lotes[2] = new Lote(3, "Moneda de 50 cent", 130, pujas);
        lotes[3] = new Lote(4, "Moneda de 2€", 140, pujas);
        lotes[4] = new Lote(5, "Moneda de 20 cent", 150, pujas);


        Subasta subasta = new Subasta(Integer.parseInt(idSubasta), "Billetes de 100€", lotes);
        Map<String, Object> model = new HashMap<>();

        model.put("subasta", subasta);

        return new ModelAndView(model, "templates/subastas/subasta.htm");

    }

    public static ModelAndView pujarLote(Request req) {

        Puja puja = new Puja(1, 333, 1);
        Puja puja2 = new Puja(3, 111, 3);
        ArrayList<Puja> pujas = new ArrayList<>();
        pujas.add(puja);
        pujas.add(puja2);

        Lote[] lotes = new Lote[5];
        lotes[0] = new Lote(1, "Billetes de 100€", 100, pujas);
        lotes[1] = new Lote(2, "Moneda de 1€", 120, pujas);
        lotes[2] = new Lote(3, "Moneda de 50 cent", 130, pujas);
        lotes[3] = new Lote(4, "Moneda de 2€", 140, pujas);
        lotes[4] = new Lote(5, "Moneda de 20 cent", 150, pujas);

        Map<String, Object> model = new HashMap<>();

        int valorPuja = Integer.parseInt(req.queryParams("valorPuja"));
        int idLote = Integer.parseInt(req.queryParams("idLote"));

        Puja puja3 = new Puja(2, valorPuja, 2);
        pujas.add(puja3);

        lotes[idLote] = new Lote(idLote, lotes[idLote].getTitulo(), 20, pujas);

        Subasta subasta = new Subasta(1, "Billetes de 100€", lotes);
        /**
         * Buscar Lote en la base de datos mediante el id y añadir PUJA y CLIENTE al historial.
         */
        model.put("subasta", subasta);
        model.put("lotes", lotes);
        return new ModelAndView(model, "templates/subastas/subasta.htm");
    }
}

package controladores;

import modelos.Pago;
import spark.ModelAndView;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

public class PagoCtrl {

    public static ModelAndView mostrarFormPago(Request req){

        Map<String, Object> model = new HashMap<>();

        return new ModelAndView(model, "templates/pagos/form_pago.htm");
    }

    public static ModelAndView realizarPago(Request req){

        Pago pago = new Pago(req.queryParams("tipoPago"), req.queryParams("cardnum"), req.queryParams("segnum"),
                req.queryParams("nomcard"), req.queryParams("nombrePago"), req.queryParams("apellidoPago"),
                req.queryParams("callePago"), req.queryParams("numeroPago"), req.queryParams("codPostalPago"),
                req.queryParams("ciudadPago"), req.queryParams("nombreEnt"), req.queryParams("apellidoEnt"),
                req.queryParams("calleEnt"), req.queryParams("numeroEnt"), req.queryParams("codPostalEnt"),
                req.queryParams("ciudadEnt"));

        Map<String, Object> model = new HashMap<>();

        if (pago.comprobarPago()) {

            model.put("success", "Pago registrado correctamente.");
            return new ModelAndView(model, "templates/pagos/lista_subastas.htm");
        }else {
            model.put("error", "Datos incorrectos, vuelva a intentarlo.");
            return new ModelAndView(model, "templates/pagos/form_pago.htm");
        }
    }
}

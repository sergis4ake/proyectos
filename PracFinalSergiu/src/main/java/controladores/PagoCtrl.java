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

        return null;
    }
}

package controladores;

import modelos.Login;
import modelos.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;


public class UsuarioCtrl {
    public static ModelAndView mostrarFormRegistro(Request req){

        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "templates/usuario/form_registro.htm");

    }

    public static ModelAndView realizarRegistro(Request req, Response res){

        Map<String, Object> model = new HashMap<>();
        Usuario usuario = new Usuario(req.queryParams("nombre"), req.queryParams("apellido"), req.queryParams("sexo"),
                req.queryParams("fecha"), req.queryParams("calle"), req.queryParams("numero"), req.queryParams("codPostal"),
                req.queryParams("ciudad"), req.queryParams("mail"), req.queryParams("clave"));

        //Si los datos son correctos.. nos vamos al formulario de login con un mensaje de registro aceptado.
        if (usuario.comprobarRegistro()){
            /**
             * INTRODUCIR LOS DATOS EN LA BASE DE DATOS.
             */
            model.put("success", "Registro correcto, bienvenido " + usuario.getNombre() + " " + usuario.getApellido() + ".");
            return new ModelAndView(model, "templates/usuario/form_login.htm");
        }else{
            model.put("error", "Los datos de registro son incorrectos.");
            return new ModelAndView(model, "templates/usuario/form_registro.htm");
        }

    }

    public static ModelAndView mostrarFormLogin(Request req){

        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "templates/usuario/form_login.htm");

    }

    public static ModelAndView realizarLogin(Request req){

        Login login = new Login(req.queryParams("em"), req.queryParams("pwd"));

        Map<String, Object> model = new HashMap<>();

        /**
         * CONSULTAR BASE DE DATOS SI LOS DATOS SON CORRECTOS
         *
         * SI SON CORRECTOS:
         *          - CONSULTAR NOMBRE Y CARGAR PAGINA DE SUBASTAS lista_subastas.htm
         * SINO:
         *          - VOLVER A CARGAR LA PAGINA form_login.htm CON UN MENSAJE DE ERROR.
         */

        if (login.comprobarLogin()){
            //CONSULTAR NOMBRE EN LA BD
            Usuario usuario = login.getUsuarioCompleto();
            String nombre = "consutar bbd";
            String apellido = "";
            model.put("success", "Login correcto, bienvenido " + nombre + " " + apellido + ".");
            return new ModelAndView(model, "templates/subastas/lista_subastas.htm");

            //Faltaría introducir dentro de la pagina lista_subastas.htm un #IF para poder mostrar el mensaje de LOGIN CORRECTO
        }else{
            model.put("error", "El email o contraseña son incorrectos, vuelve a intentarlo.");
            return new ModelAndView(model, "templates/usuario/form_login.htm");
        }

    }
}

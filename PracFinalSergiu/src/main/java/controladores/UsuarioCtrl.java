package controladores;


import java.sql.SQLException;

import dao.UsuarioDao;
import modelos.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;


public class UsuarioCtrl {
    
    public static UsuarioDao usuarioDao = new UsuarioDao();
    
    public static ModelAndView mostrarFormRegistro(Request req){

        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "templates/usuario/form_registro.html");
    }

    public static  ModelAndView realizarRegistro(Request req, Response res) {
        boolean admin = false;

        if(req.queryParams("nombre")=="admin" && req.queryParams("contrasenna")=="admin") admin=true;

        Usuario u = new Usuario();
        u.setAdmin(admin);
        u.setNombre(req.queryParams("nombre"));
        u.setApellidos(req.queryParams("apellidos"));
        u.setCalle(req.queryParams("calle"));
        u.setCiudad(req.queryParams("ciudad"));
        u.setCodPostal(Integer.parseInt(req.queryParams("codPostal")));
        u.setContrasenna(req.queryParams("contrasena"));
        u.setDni(req.queryParams("dni"));
        u.setEmail(req.queryParams("email"));
        u.setTelefono(Integer.parseInt(req.queryParams("telefono")));
        u.setTipoTarjeta(req.queryParams("tipoTarjeta"));
        u.setNumTarjeta(Integer.parseInt(req.queryParams("numTarjeta")));
        u.setCodSeguridad(Integer.parseInt(req.queryParams("codSeguridad")));

        usuarioDao.insertar(u);

        res.redirect("/login");

        return null;
    }

    public static ModelAndView mostrarFormLogin(Request req){

        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "templates/usuario/form_login.htm");

    }

    public  static ModelAndView realizarLogin(Request req, Response res){

        Usuario u = new Usuario();
        String email = req.queryParams("email");
        String contrasenna = req.queryParams("contrasenna");

        u = usuarioDao.select(email);   //Select por email del usuario.

        if (u!=null && contrasenna == u.getContrasenna()){

            req.session().attribute("email", email); //Para guardar el identificador en la sesion.
            if(u.isAdmin()){
                res.redirect("/gestionWeb");
            }
            else{
                res.redirect("/subastas");
            }
        }
        Map<String, Object> model = new HashMap<>();
        model.put("error", "Usuario/contraseña incorrectos.");
        return new ModelAndView(model, "templates/usuario/form_login.htm");

    }
    public  static ModelAndView cerrarSesion(Request req, Response res){

       req.session().removeAttribute("email");
       res.redirect("/login");
       return null;
    }
}

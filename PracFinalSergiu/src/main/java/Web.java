import static spark.Spark.*;

import controladores.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.template.velocity.VelocityTemplateEngine;


public class Web {
   
    private  final Logger LOG = LoggerFactory.getLogger(Web.class);

    public static void main(String[] args) {



        staticFiles.location("/public");

        get("/subasta/:id", (req, res) -> {
            return SubastaCtrl.mostrarLotesSubasta(req);
        }, getTemplateEngine());

        get("/subastas", (req, res) -> {
            return SubastaCtrl.mostrarSubastas(req);
        }, getTemplateEngine());

        post("/subasta/:id", (req, res) -> {
            return SubastaCtrl.pujarLote(req, res);
        }, getTemplateEngine());

        /**
         * Urls para guardar metodo de pago
         */
        get("/pagar", (req, res) -> {
            return PagoCtrl.mostrarFormPago(req);
        }, getTemplateEngine());

        post("/pagar", (req, res) -> {
            return PagoCtrl.realizarPago(req);
        }, getTemplateEngine());

        /**
         * URLs para registro y login(index)
         */
        get("/registrar", (req, res) -> {
            return UsuarioCtrl.mostrarFormRegistro(req);
        }, getTemplateEngine());

        post("/registrar", (req, res) -> {
            return UsuarioCtrl.realizarRegistro(req, res);
        }, getTemplateEngine());

        get("/login", (req, res) -> {
            return UsuarioCtrl.mostrarFormLogin(req);
        }, getTemplateEngine());

        post("/login", (req, res) -> {
            return UsuarioCtrl.realizarLogin(req, res);
        }, getTemplateEngine());


        /**
         * URLs ADMIN SUBASTAS
         */

        //Mostramos la lista de subastas con enlaces para EDITAR, BORRAR, ETC.
        get("/gestionWeb", (req, res) -> {
            return AdminSubastaCtrl.mostrarGestionWeb(req);
        }, getTemplateEngine());
        //Mostramos la lista de subastas con enlaces para EDITAR, BORRAR, ETC.
        get("/listaSubastas", (req, res) -> {
            return AdminSubastaCtrl.mostrarListaSubastas(req);
        }, getTemplateEngine());
        //Mostramos el formulario para crear subasta.
        get("/subirSubasta", (req, res) -> {
            return AdminSubastaCtrl.mostrarFormSubasta(req);
        }, getTemplateEngine());
        //Subimos la nueva subasta a la base de datos y mostramos subastas.
        post("/subirSubasta", (req, res) -> {
            return AdminSubastaCtrl.subirSubasta(req, res);
        }, getTemplateEngine());
        //Eliminamos subasta entera (junto con lotes) mediante el ID
        get("/eliminarSubasta/:id", (req, res) -> {
            return AdminSubastaCtrl.deleteSubasta(req, res);
        }, getTemplateEngine());

        //Eliminamos subasta entera (junto con lotes) mediante el ID
        get("/editarSubasta/:id", (req, res) -> {
            return AdminSubastaCtrl.editSubasta(req);
        }, getTemplateEngine());
        //Cuando enviamos el formulario de la vista anterior, actualizamos datos.
        post("/editarSubasta", (req, res) -> {
            return AdminSubastaCtrl.updateSubasta(req, res);
        }, getTemplateEngine());

        /**
         * URLs ADMIN LOTES
         */
        get("/listaLotes", (req, res) -> {
            return AdminLoteCtrl.mostrarListaLotes(req);
        }, getTemplateEngine());
        get("/subirLote", (req, res) -> {
            return AdminLoteCtrl.mostrarFormLote(req);
        }, getTemplateEngine());
        post("/subirLote", (req, res) -> {
            return AdminLoteCtrl.subirLote(req, res);
        }, getTemplateEngine());
        get("/eliminarLote/:id", (req, res) -> {
            return AdminLoteCtrl.deleteLote(req, res);
        }, getTemplateEngine());

    }

    private static VelocityTemplateEngine getTemplateEngine(){
        return new VelocityTemplateEngine();
    }
}

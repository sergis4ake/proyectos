import static spark.Spark.*;

import controladores.PagoCtrl;
import controladores.SubastaCtrl;
import controladores.UsuarioCtrl;
import controladores.AdminCtrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class Web {

    private static final Logger LOG = LoggerFactory.getLogger(Web.class);

    public static void main(String[] args) {


        staticFiles.location("/public");

        get("/subasta/:id", (req, res) -> {
            return SubastaCtrl.mostrarSubasta(req);
        }, getTemplateEngine());

        get("/subastas", (req, res) -> {
            return SubastaCtrl.mostrarSubastas(req);
        }, getTemplateEngine());

        post("/subasta/:id", (req, res) -> {
            return SubastaCtrl.pujarLote(req);
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
            return UsuarioCtrl.realizarLogin(req);
        }, getTemplateEngine());


        /**
         * URLs ADMIN para la subida/modificacion de datos en la base de datos.
         */

        //Mostramos la lista de subastas con enlaces para EDITAR, BORRAR, ETC.
        get("/listaSubastas", (req, res) -> {
            return AdminCtrl.mostrarListaSubastas(req);
        }, getTemplateEngine());

        //Editamos el nombre de una subasta
        get("/editarSubasta/:id", (req, res) -> {
            return AdminCtrl.editSubasta(req);
        }, getTemplateEngine());
        //Cuando enviamos el formulario de la vista anterior, actualizamos datos.
        post("/editarSubasta", (req, res) -> {
            return AdminCtrl.updateSubasta(req);
        }, getTemplateEngine());
        //Eliminamos subasta entera (junto con lotes) mediante el ID
        get("/eliminarSubasta/:id", (req, res) -> {
            return AdminCtrl.deleteSubasta(req);
        }, getTemplateEngine());
        //Mostramos el formulario para crear subasta.
        get("/subirSubasta", (req, res) -> {
            return AdminCtrl.mostrarFormSubasta(req);
        }, getTemplateEngine());
        //Subimos la nueva subasta a la base de datos y mostramos subastas.
        post("/subirSubasta", (req, res) -> {
            return AdminCtrl.subirSubasta(req);
        }, getTemplateEngine());

        /**
         * URLs de gestion de LOTES.
         */
        get("/listaLotes/:id", (req, res) -> {
            return AdminCtrl.mostrarListaLotes(req);
        }, getTemplateEngine());


        post("/subirLote", (req, res) -> {
            return AdminCtrl.subirLote(req);
        }, getTemplateEngine());
        get("/subirLote/:id", (req, res) -> {
            return AdminCtrl.mostrarFormLote(req);
        }, getTemplateEngine());

    }

    private static VelocityTemplateEngine getTemplateEngine(){
        return new VelocityTemplateEngine();
    }
}

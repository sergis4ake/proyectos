package modelos;

public class Subasta {
    private int id;
    private String titulo;
    private Lote [] lotes;

    public Subasta(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Subasta(int id) {
        this.id = id;
    }

    public Subasta(String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Subasta(int id, String titulo, Lote [] lotes) {
        this.id = id;
        this.titulo = titulo;
        this.lotes = lotes;
    }

    public void uploadToBBDD(){
        /**
         * CONEXION CON BASE DE DATOS PARA GUARDAR LOS DATOS EN BBDD.
         * Guardar los datos del objeto subasta en la base de datos.
         */
    }
    public void downloadFromBBDD(){
        /**
         * CONEXION CON BBDD PARA DESCARGAR DATOS DE UNA SUBASTA MEDIANTE EL ID DE SUBASTA.
         * Guardar los datos obtenidos en los atributos del objeto.
         */
    }
    public void updateToBBDD(){
        /**
         * CONEXION CON BBDD PARA ACTUALIZAR LOS DATOS INTRODUCIDOS.
         * Los datos los contiene el objeto subasta, solo hay que hacer consulta con base de datos.
         */
    }
    public void borrar(){
        /**
         * BORRAR SUBASTA DE LA BASE DE DATOS MEDIANTE EL ID.
         * Buscar en la base de datos el id que contiene el objeto subasta para hacer un delete de la subasta.
         */
    }

    public Lote [] getLotes() {
        return lotes;
    }

    public void setLotes(Lote [] lotes) {
        this.lotes = lotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return "subasta/" + id;
    }
    public String getLinkEdit() {
        return "editarSubasta/" + id;
    }
    public String getLinkDelete() {
        return "eliminarSubasta/" + id;
    }
    public String getLinkNew() {
        return "subirSubasta";
    }
    public String getLinkLotes(){
        return "listaLotes/" + id;
    }
}

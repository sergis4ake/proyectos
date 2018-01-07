package modelos;

public class Subasta {
    private int id;
    private String titulo;
    private Lote [] lotes;

    public Subasta(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
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
}

package modelos;

import java.util.ArrayList;
import java.util.Date;

public class Subasta {

    private long idSubasta;
    private String titulo;
    private Date finalizacion;
    private ArrayList<Lote> lotes;

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }

    public long getIdSubasta() {
        return idSubasta;
    }

    public void setIdSubasta(long idSubasta) {
        this.idSubasta = idSubasta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(Date finalizacion) {
        this.finalizacion = finalizacion;
    }

    public String getLink() {
        return "/subasta/" + idSubasta;
    }

    public String getLinkEdit() {
        return "/editarSubasta/" + idSubasta;
    }

    public String getLinkDelete() {
        return "/eliminarSubasta/" + idSubasta;
    }

    public String getLinkNew() {
        return "/subirSubasta";
    }

}

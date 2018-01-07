package modelos;

public class Puja {

    private int id;
    private int valor;
    private int idUsuario;

    public Puja(int id, int valor, int idUsuario) {
        this.id = id;
        this.valor = valor;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

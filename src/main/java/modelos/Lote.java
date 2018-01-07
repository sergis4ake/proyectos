package modelos;

import java.util.ArrayList;
public class Lote {

    private int id;
    private String titulo;
    private String valor;
    private int anio;
    private String lugar;
    private String fecha;
    private String serie;
    private int consevacion;
    private int precio;
    private ArrayList<Puja> pujas;
    private static String [] tipoConservacion = {"BC", "MBC", "EBC", "SC"};

    public Lote(String titulo, String valor, int anio, String lugar, String fecha, String serie,
                int consevacion, int precio, ArrayList<Puja> pujas) {
        this.id = id;
        this.titulo = titulo;
        this.valor = valor;
        this.anio = anio;
        this.lugar = lugar;
        this.fecha = fecha;
        this.serie = serie;
        this.consevacion = consevacion;
        this.precio = precio;
        this.pujas = pujas;
    }

    public Lote(int id, String titulo, int precio, ArrayList<Puja> pujas) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.pujas = pujas;
    }

    public void loadToBBDD(){
        /**
         * CONEXION CON BASE DE DATOS PARA CARGAR LOS DATOS.
         */
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getConsevacion() {
        return consevacion;
    }

    public String getConservacion(){
        return tipoConservacion[this.consevacion];
    }

    public void setConsevacion(int consevacion) {
        this.consevacion = consevacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<Puja> getPujas() {
        return pujas;
    }

    public void setPujas(ArrayList<Puja> pujas) {
        this.pujas = pujas;
    }

    public void addPuja(Puja puja){
        pujas.add(puja);
    }
}

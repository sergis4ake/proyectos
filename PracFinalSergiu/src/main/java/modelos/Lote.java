/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


import java.util.ArrayList;
import java.util.Date;

public class Lote {

    private int idLote;
    private int idSubasta;
    private String tipo;
    private String valor;
    private double precio;
    private String foto;
    private int anno;
    private String conservacion;
    private String serie;
    private String estrellas;
    private Date fechaLote;
    private ArrayList<Puja> pujas;

    public ArrayList<Puja> getPujas() {
        return pujas;
    }

    public void setPujas(ArrayList<Puja> pujas) {
        this.pujas = pujas;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getConservacion() {
        return conservacion;
    }

    public void setConservacion(String conservacion) {
        this.conservacion = conservacion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }

    public Date getFechaLote() {
        return fechaLote;
    }

    public void setFechaLote(Date fechaLote) {
        this.fechaLote = fechaLote;
    }

    public int getIdSubasta() {
        return idSubasta;
    }

    public void setIdSubasta(int idSubasta) {
        this.idSubasta = idSubasta;
    }

    public String getLinkDelete (){
        return "/eliminarLote/" + idLote;
    }

    public String getLinkNew(){
        return "/subirLote";
    }
}

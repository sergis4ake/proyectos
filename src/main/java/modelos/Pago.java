package modelos;

public class Pago {

    private String tipo;
    private String cardnum;
    private String segnum;
    private String nomcard;
    private String nombrePago;
    private String apellidoPago;
    private String callePago;
    private String numeroPago;
    private String codPostalPago;
    private String ciudadPago;
    private String nombreEnt;
    private String apellidoEnt;
    private String calleEnt;
    private String numeroEnt;
    private String getCodPostalEnt;
    private String getCiudadEnt;

    public Pago(String tipo, String cardnum, String segnum, String nomcard, String nombrePago,
                String apellidoPago, String callePago, String numeroPago, String codPostalPago,
                String ciudadPago, String nombreEnt, String apellidoEnt, String calleEnt,
                String numeroEnt, String getCodPostalEnt, String getCiudadEnt) {
        this.tipo = tipo;
        this.cardnum = cardnum;
        this.segnum = segnum;
        this.nomcard = nomcard;
        this.nombrePago = nombrePago;
        this.apellidoPago = apellidoPago;
        this.callePago = callePago;
        this.numeroPago = numeroPago;
        this.codPostalPago = codPostalPago;
        this.ciudadPago = ciudadPago;
        this.nombreEnt = nombreEnt;
        this.apellidoEnt = apellidoEnt;
        this.calleEnt = calleEnt;
        this.numeroEnt = numeroEnt;
        this.getCodPostalEnt = getCodPostalEnt;
        this.getCiudadEnt = getCiudadEnt;
    }

    public boolean comprobarPago(){
        /**
         * Comprueba que los datos introducidos son correctos.
         */
        return false;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getSegnum() {
        return segnum;
    }

    public void setSegnum(String segnum) {
        this.segnum = segnum;
    }

    public String getNomcard() {
        return nomcard;
    }

    public void setNomcard(String nomcard) {
        this.nomcard = nomcard;
    }

    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }

    public String getApellidoPago() {
        return apellidoPago;
    }

    public void setApellidoPago(String apellidoPago) {
        this.apellidoPago = apellidoPago;
    }

    public String getCallePago() {
        return callePago;
    }

    public void setCallePago(String callePago) {
        this.callePago = callePago;
    }

    public String getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(String numeroPago) {
        this.numeroPago = numeroPago;
    }

    public String getCodPostalPago() {
        return codPostalPago;
    }

    public void setCodPostalPago(String codPostalPago) {
        this.codPostalPago = codPostalPago;
    }

    public String getCiudadPago() {
        return ciudadPago;
    }

    public void setCiudadPago(String ciudadPago) {
        this.ciudadPago = ciudadPago;
    }

    public String getNombreEnt() {
        return nombreEnt;
    }

    public void setNombreEnt(String nombreEnt) {
        this.nombreEnt = nombreEnt;
    }

    public String getApellidoEnt() {
        return apellidoEnt;
    }

    public void setApellidoEnt(String apellidoEnt) {
        this.apellidoEnt = apellidoEnt;
    }

    public String getCalleEnt() {
        return calleEnt;
    }

    public void setCalleEnt(String calleEnt) {
        this.calleEnt = calleEnt;
    }

    public String getNumeroEnt() {
        return numeroEnt;
    }

    public void setNumeroEnt(String numeroEnt) {
        this.numeroEnt = numeroEnt;
    }

    public String getGetCodPostalEnt() {
        return getCodPostalEnt;
    }

    public void setGetCodPostalEnt(String getCodPostalEnt) {
        this.getCodPostalEnt = getCodPostalEnt;
    }

    public String getGetCiudadEnt() {
        return getCiudadEnt;
    }

    public void setGetCiudadEnt(String getCiudadEnt) {
        this.getCiudadEnt = getCiudadEnt;
    }
}

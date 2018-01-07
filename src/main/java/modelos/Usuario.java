package modelos;

public class Usuario {

    private String nombre;
    private String apellido;
    private String sexo;
    private String fecha;
    private String calle;
    private String numero;
    private String codPostal;
    private String ciudad;
    private String mail;
    private String clave;

    public Usuario(String nombre, String apellido, String sexo, String fecha,
                   String calle, String numero, String codPostal, String ciudad,
                   String mail, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecha = fecha;
        this.calle = calle;
        this.numero = numero;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
        this.mail = mail;
        this.clave = clave;
    }


    public boolean comprobarRegistro(){
        /**
         * Comprobamos que los datos introducidos son correctos.
         */
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}


package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class Usuario {

    private String email;
    private String contrasenna;
    private String nombre;
    private String apellidos;
    private long telefono;
    private String ciudad;
    private long codPostal;
    private String dni;
    private String calle;
    private boolean admin;
    private long numTarjeta;
    private String tipoTarjeta;
    private long codSeguridad;


    public long getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(long codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(long codPostal) {
        this.codPostal = codPostal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public long getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
}

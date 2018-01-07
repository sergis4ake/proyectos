package modelos;

public class Login {

    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean comprobarLogin(){
        /**
         * Comprobar en la base de datos que el loggin es correcto
         */
        return false;
    }

    public Usuario getUsuarioCompleto(){
        /**
         * Sacamos los datos del usuario que corresponde con el email
         * y los insertamos en nuevo objeto de tipo Usuario.
         */
        Usuario usuario = new Usuario("", "", "", "", "", "", "", "", "", "");
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

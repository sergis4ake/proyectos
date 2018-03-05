package dao.mappers;
import modelos.Usuario;

public interface UsuarioMapper {

    Usuario select(String email);

    Long insert(Usuario u);

}
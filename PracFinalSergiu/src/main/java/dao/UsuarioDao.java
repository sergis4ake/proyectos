package dao;

import modelos.Usuario;
import dao.mappers.UsuarioMapper;


public class UsuarioDao extends BaseDao {

    UsuarioMapper mapper;
    public UsuarioDao(){
        mapper = getSesion().getMapper(UsuarioMapper.class);
    }

    public Usuario select(String email){
        return mapper.select(email);
    }

    public Long insertar(Usuario u){
        return mapper.insert(u);
    }

}

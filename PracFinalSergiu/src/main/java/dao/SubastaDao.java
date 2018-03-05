package dao;

import dao.mappers.SubastaMapper;
import modelos.Subasta;

import java.util.ArrayList;

public class SubastaDao extends BaseDao {

    SubastaMapper mapper;
    public SubastaDao(){
        mapper = getSesion().getMapper(SubastaMapper.class);
    }

    public ArrayList<Subasta> selectAll(){
        return mapper.selectAll();
    }

    public Subasta select(long idSubasta){
        return mapper.select(idSubasta);
    }

    public Long insertar(Subasta s){
        return mapper.insert(s);
    }

    public Long actualizar(Subasta s){
        return mapper.update(s);
    }

    public Long eliminar(long idSubasta) {
        return mapper.delete(idSubasta);
    }
}

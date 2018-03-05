package dao;

import dao.mappers.PujaMapper;
import modelos.Puja;

import java.util.ArrayList;

public class PujaDao extends BaseDao {

    PujaMapper mapper;
    public PujaDao(){
        mapper = getSesion().getMapper(PujaMapper.class);
    }

    public ArrayList<Puja> selectAll(){
        return (ArrayList<Puja>)mapper.selectAll();
    }

    public ArrayList<Puja> selectFromLote(long idLote){
        return (ArrayList<Puja>)mapper.selectDeLote(idLote);
    }

    public Long insertar(Puja p){
        return mapper.insert(p);
    }

    public Long eliminar(long idPuja){
        return mapper.delete(idPuja);
    }

    public Puja select(long idPuja){
        return mapper.select(idPuja);
    }

}
package dao;

import dao.mappers.LoteMapper;
import modelos.Lote;

import java.util.ArrayList;

public class LoteDao extends BaseDao {

    LoteMapper mapper;
    public LoteDao(){
        mapper = getSesion().getMapper(LoteMapper.class);
    }

    public ArrayList<Lote> selectAll(){
        return (ArrayList<Lote>)mapper.selectAll();
    }

    public ArrayList<Lote> selectFromSubasta(long idSubasta){
        return (ArrayList<Lote>)mapper.selectDeSubasta(idSubasta);
    }

    public Long insertar(Lote l){
        return mapper.insert(l);
    }

    public Long eliminar(long idLote){
        return mapper.delete(idLote);
    }

    public Lote select(long idLote){
        return mapper.select(idLote);
    }

}
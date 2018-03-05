package dao.mappers;
import modelos.Puja;
import java.util.List;

public interface PujaMapper {

    Puja select(Long idPuja);

    List<Puja> selectAll();

    List<Puja> selectDeLote(Long idLote);

    Long insert(Puja puja);

    Long delete(long idPuja);

}
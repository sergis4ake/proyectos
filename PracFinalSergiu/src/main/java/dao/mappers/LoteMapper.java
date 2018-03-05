package dao.mappers;

import modelos.Lote;
import java.util.List;

public interface LoteMapper {


    Lote select(Long idLote);


    List<Lote> selectAll();

    List<Lote> selectDeSubasta(Long idSubasta);

    Long insert(Lote l);
    Long delete(Long idLote);


}

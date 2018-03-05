package dao.mappers;
import modelos.Subasta;

import java.util.ArrayList;
import java.util.List;

public interface SubastaMapper {

    Subasta select(Long idSubasta);

    ArrayList<Subasta> selectAll();

    Long insert(Subasta subasta);

    Long update(Subasta subasta);

    Long delete(long idSubasta);

}

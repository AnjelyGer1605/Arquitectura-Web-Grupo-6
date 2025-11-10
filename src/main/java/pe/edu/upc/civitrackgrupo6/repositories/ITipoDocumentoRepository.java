package pe.edu.upc.civitrackgrupo6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.civitrackgrupo6.entities.Tipodocumento;

import java.util.List;
@Repository
public interface ITipoDocumentoRepository extends JpaRepository<Tipodocumento, Integer> {

    // US48 – Tipos de documento activos
    @Query("SELECT t FROM Tipodocumento t WHERE t.estado = 'Activo' ORDER BY t.nombre ASC")
    List<Tipodocumento> findTiposDocumentoActivos();

}

package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.code_civitrack.entities.Tipodocumento;

import java.util.List;

public interface ITipoDocumentoRepository extends JpaRepository<Tipodocumento, Integer> {
    @Query("SELECT td FROM Tipodocumento td WHERE LOWER(td.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Tipodocumento> buscarPorNombre(@Param("nombre") String nombre);
}

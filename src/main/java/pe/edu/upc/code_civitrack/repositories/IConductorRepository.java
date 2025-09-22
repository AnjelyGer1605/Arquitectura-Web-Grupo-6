package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Conductor;
import pe.edu.upc.code_civitrack.entities.Conductor;

import java.util.List;

@Repository
public interface IConductorRepository extends JpaRepository<Conductor,Long> {
    @Query("SELECT c FROM Conductor c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Conductor> buscarPorNombre(@Param("nombre") String nombre);

}

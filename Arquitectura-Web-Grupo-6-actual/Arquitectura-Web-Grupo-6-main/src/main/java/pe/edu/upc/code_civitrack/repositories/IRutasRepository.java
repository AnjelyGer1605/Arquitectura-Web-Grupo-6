package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Rutas;
import pe.edu.upc.code_civitrack.entities.Rutas;

import java.util.List;

@Repository
public interface IRutasRepository extends JpaRepository<Rutas,Integer> {
    @Query("SELECT r FROM Rutas r WHERE LOWER(r.nombreruta) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Rutas> buscarPorNombre(@Param("nombre") String nombre);


}

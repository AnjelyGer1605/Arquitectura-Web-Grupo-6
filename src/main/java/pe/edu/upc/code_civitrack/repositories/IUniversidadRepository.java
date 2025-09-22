package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Universidad;

import java.util.List;

@Repository
public interface IUniversidadRepository extends JpaRepository<Universidad, Integer> {

    // Buscar universidad por nombre exacto
    @Query("SELECT u FROM Universidad u WHERE u.nombreUniversidad = :nombre")
    List<Universidad> buscarPorNombre(@Param("nombre") String nombre);

    // Buscar con LIKE (contiene)
    @Query("SELECT u FROM Universidad u WHERE LOWER(u.nombreUniversidad) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Universidad> buscarPorNombreContiene(@Param("nombre") String nombre);
}

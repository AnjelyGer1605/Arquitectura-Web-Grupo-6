package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Universidad;

import java.util.List;

@Repository
public interface IUniversidadRepository extends JpaRepository<Universidad, Integer> {
    List<Universidad> findBynombreUniversidad_nombreUniversidad(String nombreUniversidad);
}

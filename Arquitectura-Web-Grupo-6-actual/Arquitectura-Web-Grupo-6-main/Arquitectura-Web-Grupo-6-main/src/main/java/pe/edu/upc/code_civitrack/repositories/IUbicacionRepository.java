package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Ubicacion;
@Repository
public interface IUbicacionRepository extends JpaRepository<Ubicacion,Integer> {
}

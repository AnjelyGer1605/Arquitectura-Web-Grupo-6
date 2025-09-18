package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Estudiante;

import java.util.List;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

    Estudiante findBycodigoEstudiante_codigoEstudiante(String codigoEstudiante);
    List<Estudiante> findBycarreraEstudiante_carreraEstudiante(String carreraEstudiante);

}

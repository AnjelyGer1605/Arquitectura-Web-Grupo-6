package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Estudiante;

import java.util.List;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {
    // Buscar estudiante por código exacto
    @Query("SELECT e FROM Estudiante e WHERE e.codigoEstudiante = :codigoEstudiante")
    Estudiante buscarPorCodigo(@Param("codigoEstudiante") String codigoEstudiante);

    // Buscar estudiantes por carrera exacta
    @Query("SELECT e FROM Estudiante e WHERE e.carreraEstudiante = :carrera")
    List<Estudiante> buscarPorCarrera(@Param("carrera") String carrera);

    // Buscar estudiantes por carrera que contenga texto
    @Query("SELECT e FROM Estudiante e WHERE LOWER(e.carreraEstudiante) LIKE LOWER(CONCAT('%', :carrera, '%'))")
    List<Estudiante> buscarCarreraContiene(@Param("carrera") String carrera);

    Estudiante findByCodigoEstudiante(String codigoEstudiante);

    List<Estudiante> findByCarreraEstudiante(String carreraEstudiante);
}

package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Estudiante;

import java.util.List;

public interface IEstudianteService {

    List<Estudiante> list();
    void insert(Estudiante estudiante);
    void delete(int id);
    Estudiante listId(int id);
    void update(Estudiante estudiante);

    Estudiante findBycodigoEstudiante(String codigoEstudiante);
    List<Estudiante> findBycarreraEstudiante(String carreraEstudiante);
}

package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Estudiante;

import java.util.List;

public interface IEstudianteService {

    public List<Estudiante> list();
    public void insert(Estudiante estudiante);
    public void delete(int id);
    public Estudiante listId(int id);
    public void update(Estudiante estudiante);

    public Estudiante findBycodigoEstudiante(String codigoEstudiante);
    public List<Estudiante> findBycarreraEstudiante(String carreraEstudiante);
}

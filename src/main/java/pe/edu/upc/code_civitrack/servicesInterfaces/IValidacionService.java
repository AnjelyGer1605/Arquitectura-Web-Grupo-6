package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Validacion;

import java.time.LocalDate;
import java.util.List;

public interface IValidacionService {
    List<Validacion> list();
    void insert(Validacion validacion);
    void delete(int id);
    Validacion listId(int id);
    void update(Validacion validacion);
    List<Validacion> buscarService(LocalDate fecha);
}
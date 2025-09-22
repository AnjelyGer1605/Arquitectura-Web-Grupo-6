package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Conductor;
import pe.edu.upc.code_civitrack.entities.Rutas;

import java.util.List;

public interface IConductorservice {
    List<Conductor> list();
    void insert(Conductor conductor);
    void delete(Long id);
    Conductor listId(Long id);
    void update(Conductor conductor);
}

package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Conductor;
import pe.edu.upc.code_civitrack.entities.Rutas;

import java.util.List;

public interface IConductorservice {
    public List<Conductor> list();
    public void insert(Conductor conductor);
    public void delete(Long id);
    public Conductor listId(Long id);
    public void update(Conductor conductor);
}

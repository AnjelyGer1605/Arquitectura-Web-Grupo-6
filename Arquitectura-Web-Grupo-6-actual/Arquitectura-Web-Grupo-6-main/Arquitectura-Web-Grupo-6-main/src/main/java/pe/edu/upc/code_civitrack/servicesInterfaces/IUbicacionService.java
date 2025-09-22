package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Ubicacion;

import java.util.Collection;
import java.util.List;

public interface IUbicacionService {
    // Collection<Object> list();

    void insert(Ubicacion u);
    public List<Ubicacion> list();
}

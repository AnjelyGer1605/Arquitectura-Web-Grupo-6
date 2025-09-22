package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Rutas;
import pe.edu.upc.code_civitrack.entities.Usuario;

import java.util.List;

public interface IRutasservice {
    List<Rutas> list();
    void insert(Rutas rutas);
    void delete(int id);
    Rutas listId(int id);
    void update(Rutas rutas);

}

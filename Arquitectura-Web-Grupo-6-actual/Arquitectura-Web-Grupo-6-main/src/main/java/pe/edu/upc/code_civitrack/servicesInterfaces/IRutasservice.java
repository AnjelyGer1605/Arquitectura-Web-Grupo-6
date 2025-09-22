package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Rutas;
import pe.edu.upc.code_civitrack.entities.Usuario;

import java.util.List;

public interface IRutasservice {
    public List<Rutas> list();
    public void insert(Rutas rutas);
    public void delete(int id);
    public Rutas listId(int id);
    public void update(Rutas rutas);

}

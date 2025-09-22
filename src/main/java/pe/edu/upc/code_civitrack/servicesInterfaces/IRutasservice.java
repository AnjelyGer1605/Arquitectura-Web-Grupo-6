package pe.edu.upc.demotrabajocivitrak.Servicesinterfaces;

import pe.edu.upc.demotrabajocivitrak.Entities.Rutas;
import pe.edu.upc.demotrabajocivitrak.Entities.Usuario;

import java.util.List;

public interface IRutasservice {
    public List<Rutas> list();
    public void insert(Rutas rutas);
    public void delete(int id);
    public Rutas listId(int id);
    public void update(Rutas rutas);

}

package pe.edu.upc.demotrabajocivitrak.Servicesinterfaces;

import pe.edu.upc.demotrabajocivitrak.Entities.Conductor;
import pe.edu.upc.demotrabajocivitrak.Entities.Rutas;

import java.util.List;

public interface IConductorservice {
    public List<Conductor> list();
    public void insert(Conductor conductor);
    public void delete(Long id);
    public Conductor listId(Long id);
    public void update(Conductor conductor);
}

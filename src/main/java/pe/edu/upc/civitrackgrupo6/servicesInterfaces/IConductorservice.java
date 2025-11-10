package pe.edu.upc.civitrackgrupo6.servicesInterfaces;

import pe.edu.upc.civitrackgrupo6.entities.Conductor;

import java.util.List;

public interface IConductorservice {
    List<Conductor> list();
    void insert(Conductor conductor);
    void delete(Long id);
    Conductor listId(Long id);
    void update(Conductor conductor);

    List<Conductor> findTopConductores(); // US29

}

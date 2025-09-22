package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Solicitud;

import java.util.List;

public interface ISolicitudService {
    List<Solicitud> list();
    void insert(Solicitud solicitud);
    void delete(int id);
    Solicitud listId(int id);
    void update(Solicitud solicitud);
}

package pe.edu.upc.civitrackgrupo6.servicesInterfaces;

import pe.edu.upc.civitrackgrupo6.entities.Solicitud;

import java.util.List;

public interface ISolicitudService {
    List<Solicitud> list();
    void insert(Solicitud solicitud);
    void delete(int id);
    Solicitud listId(int id);
    void update(Solicitud solicitud);

    List<Solicitud> findSolicitudesPorEstado(String estado);
}

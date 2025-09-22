package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Notificacion;

import java.time.LocalDate;
import java.util.List;

public interface INotificacionService {
    List<Notificacion> list();
    void insert(Notificacion notificacion);
    void delete(int id);
    Notificacion listId(int id);
    void update(Notificacion notificacion);
    List<Notificacion> buscarService(LocalDate fecha);
}


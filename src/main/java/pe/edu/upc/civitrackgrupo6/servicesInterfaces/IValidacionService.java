package pe.edu.upc.civitrackgrupo6.servicesInterfaces;

import pe.edu.upc.civitrackgrupo6.entities.Validacion;

import java.util.List;

public interface IValidacionService {
    List<Validacion> list();
    void insert(Validacion validacion);
    void delete(int id);
    Validacion listId(int id);
    void update(Validacion validacion);
    List<Validacion> findValidacionesPorReporte(Long idReporte);
}
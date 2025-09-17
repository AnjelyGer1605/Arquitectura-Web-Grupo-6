package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Reporte;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;



public interface IReporteService {
    // Collection<Object> list();

    public List<Reporte> list();
    void insert(Reporte reporte);

    Reporte listId(int id);

    void delete(int id);

    void update(Reporte re);

    List<Reporte> buscarService(LocalDate f);
}

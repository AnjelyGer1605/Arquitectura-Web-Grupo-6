package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.HistorialRuta;

import java.time.LocalDate;
import java.util.List;

public interface IHistorialRutaService {
    List<HistorialRuta> list();
    void insert(HistorialRuta historialRuta);
    void delete(int id);
    HistorialRuta listId(int id);
    void update(HistorialRuta historialRuta);
    List<HistorialRuta> buscarService(LocalDate fecha);
}


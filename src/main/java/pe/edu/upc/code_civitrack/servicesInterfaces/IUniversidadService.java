package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Universidad;


import java.util.List;

public interface IUniversidadService {

    List<Universidad> list();
    void insert(Universidad universidad);
    void delete(int id);
    Universidad listId(int id);
    void update(Universidad universidad);

    List<Universidad> findBynombreUniversidad(String nombreUniversidad);

}

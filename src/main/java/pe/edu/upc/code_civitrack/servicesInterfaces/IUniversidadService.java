package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Universidad;


import java.util.List;

public interface IUniversidadService {

    public List<Universidad> list();
    public void insert(Universidad universidad);
    public void delete(int id);
    public Universidad listId(int id);
    public void update(Universidad universidad);

    public List<Universidad> findBynombreUniversidad(String nombreUniversidad);

}

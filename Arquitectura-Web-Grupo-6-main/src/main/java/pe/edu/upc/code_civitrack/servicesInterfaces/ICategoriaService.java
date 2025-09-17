package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Categoria;

import java.util.Collection;
import java.util.List;

public interface ICategoriaService {
    //  Collection<Object> list();

    void insert(Categoria c);
    public List<Categoria> list();
}

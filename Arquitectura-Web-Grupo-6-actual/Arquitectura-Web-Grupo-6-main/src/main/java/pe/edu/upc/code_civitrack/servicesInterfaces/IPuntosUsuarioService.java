package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.PuntosUsuario;

import java.util.List;

public interface IPuntosUsuarioService {
    List<PuntosUsuario> list();
    void insert(PuntosUsuario puntosUsuario);
    void delete(int id);
    PuntosUsuario listId(int id);
    void update(PuntosUsuario puntosUsuario);
}

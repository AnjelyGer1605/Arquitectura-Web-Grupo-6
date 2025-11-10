package pe.edu.upc.civitrackgrupo6.servicesInterfaces;

import pe.edu.upc.civitrackgrupo6.entities.PuntosUsuario;

import java.util.List;

public interface IPuntosUsuarioService {
    List<PuntosUsuario> list();
    void insert(PuntosUsuario puntosUsuario);
    void delete(int id);
    PuntosUsuario listId(int id);
    void update(PuntosUsuario puntosUsuario);
    Integer totalPuntosPorUsuario(Long idUsuario);     // US45
    List<Object[]> rankingUsuarios();
}

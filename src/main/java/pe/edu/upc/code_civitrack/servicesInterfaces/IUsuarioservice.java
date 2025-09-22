package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IUsuarioservice {
    List<Usuario> list();
    void insert(Usuario usuario);
    void delete(int id);
    Usuario listId(int id);
    void update(Usuario usuario);


}

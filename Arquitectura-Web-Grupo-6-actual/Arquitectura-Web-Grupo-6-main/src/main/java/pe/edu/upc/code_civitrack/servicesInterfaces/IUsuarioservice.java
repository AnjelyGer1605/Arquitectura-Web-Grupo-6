package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IUsuarioservice {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void delete(int id);
    public Usuario listId(int id);
    public void update(Usuario usuario);


}

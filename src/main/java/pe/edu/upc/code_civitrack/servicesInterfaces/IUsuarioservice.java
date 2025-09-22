package pe.edu.upc.demotrabajocivitrak.Servicesinterfaces;

import pe.edu.upc.demotrabajocivitrak.Entities.Usuario;

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

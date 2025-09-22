package pe.edu.upc.demotrabajocivitrak.Servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demotrabajocivitrak.Entities.Usuario;
import pe.edu.upc.demotrabajocivitrak.Repositories.IUsuarioRepository;
import pe.edu.upc.demotrabajocivitrak.Servicesinterfaces.IUsuarioservice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServiceImplements implements IUsuarioservice {

    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);

    }

    @Override
    public void delete(int id) {

        uR.deleteById(id);

    }

    @Override
    public Usuario listId(int id) {

        return uR.findById(id).orElse(null);
    }

    @Override
    public void update(Usuario usuario) {

        uR.save(usuario);

    }

}

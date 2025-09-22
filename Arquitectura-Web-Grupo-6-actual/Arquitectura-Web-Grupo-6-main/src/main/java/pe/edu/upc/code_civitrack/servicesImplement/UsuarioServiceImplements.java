package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Usuario;
import pe.edu.upc.code_civitrack.servicesInterfaces.IUsuarioservice;
import java.util.List;

@Service
public class UsuarioServiceImplements implements IUsuarioservice {

    @Autowired
    private pe.edu.upc.code_civitrack.repositories.IUsuarioRepository uR;

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

package pe.edu.upc.civitrackgrupo6.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.civitrackgrupo6.entities.Usuario;
import pe.edu.upc.civitrackgrupo6.repositories.IUsuarioRepository;
import pe.edu.upc.civitrackgrupo6.servicesInterfaces.IUsuarioservice;
import java.util.List;

@Service
public class UsuarioServiceImplements implements IUsuarioservice {

    @Autowired
    private IUsuarioRepository uR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        String encodedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);
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

    @Override
    public Usuario findByCorreo(String correo) {
        return uR.findByCorreo(correo);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return uR.existsByCorreo(correo);
    }
}

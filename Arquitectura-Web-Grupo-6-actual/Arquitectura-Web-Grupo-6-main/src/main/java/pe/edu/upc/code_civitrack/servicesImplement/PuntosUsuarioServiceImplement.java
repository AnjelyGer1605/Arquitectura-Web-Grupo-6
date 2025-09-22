package pe.edu.upc.code_civitrack.servicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.PuntosUsuario;
import pe.edu.upc.code_civitrack.repositories.IPuntosUsuarioRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IPuntosUsuarioService;

import java.util.List;


@Service
public class PuntosUsuarioServiceImplement implements IPuntosUsuarioService {
    @Autowired
    private IPuntosUsuarioRepository pR;

    @Override
    public List<PuntosUsuario> list() {
        return pR.findAll();
    }

    @Override
    public void insert(PuntosUsuario puntosUsuario) {
        pR.save(puntosUsuario);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public PuntosUsuario listId(int id) {
        return pR.findById(id).orElse(null);
    }

    @Override
    public void update(PuntosUsuario puntosUsuario) {
        pR.save(puntosUsuario);
    }

}

package pe.edu.upc.civitrackgrupo6.servicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.civitrackgrupo6.entities.PuntosUsuario;
import pe.edu.upc.civitrackgrupo6.repositories.IPuntosUsuarioRepository;
import pe.edu.upc.civitrackgrupo6.servicesInterfaces.IPuntosUsuarioService;

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

    @Override
    public Integer totalPuntosPorUsuario(Long idUsuario) {
        return pR.totalPuntosPorUsuario(idUsuario);
    }

    @Override
    public List<Object[]> rankingUsuarios() {
        return pR.rankingUsuarios();
    }

}

package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Rutas;
import pe.edu.upc.code_civitrack.repositories.IRutasRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IRutasservice;

import java.util.List;

@Service
public class RutasServiceImplements implements IRutasservice {
    @Autowired
    private IRutasRepository iR;


    @Override
    public List<Rutas> list() {
        return iR.findAll();
    }

    @Override
    public void insert(Rutas usuario) {
        iR.save(usuario);

    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);

    }

    @Override
    public Rutas listId(int id) {
        return iR.findById(id).orElse(null);
    }

    @Override
    public void update(Rutas usuario) {

        iR.save(usuario);

    }
}

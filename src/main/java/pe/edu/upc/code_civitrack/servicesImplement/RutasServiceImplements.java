package pe.edu.upc.demotrabajocivitrak.Servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demotrabajocivitrak.Entities.Rutas;
import pe.edu.upc.demotrabajocivitrak.Repositories.IRutasRepository;
import pe.edu.upc.demotrabajocivitrak.Servicesinterfaces.IRutasservice;

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

package pe.edu.upc.demotrabajocivitrak.Servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demotrabajocivitrak.Entities.Conductor;
import pe.edu.upc.demotrabajocivitrak.Entities.Rutas;
import pe.edu.upc.demotrabajocivitrak.Repositories.IConductorRepository;
import pe.edu.upc.demotrabajocivitrak.Servicesinterfaces.IConductorservice;

import java.util.List;

@Service
public class ConductorServiceImplements implements IConductorservice {

    @Autowired
    private IConductorRepository cR;


    @Override
    public List<Conductor> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Conductor conductor) {
        cR.save(conductor);

    }

    @Override
    public void delete(Long id) {
        cR.deleteById(id);

    }

    @Override
    public Conductor listId(Long id) {
        return cR.findById(id).orElse(null);
    }

    @Override
    public void update(Conductor conductor) {
        cR.save(conductor);

    }
}

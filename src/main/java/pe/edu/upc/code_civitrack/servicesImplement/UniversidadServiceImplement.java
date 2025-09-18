package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Universidad;
import pe.edu.upc.code_civitrack.repositories.IUniversidadRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IUniversidadService;

import java.util.List;


@Service
public class UniversidadServiceImplement implements IUniversidadService {
    @Autowired
    private IUniversidadRepository uR;

    @Override
    public List<Universidad> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Universidad universidad) {
        uR.save(universidad);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public Universidad listId(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void update(Universidad universidad) {
        uR.save(universidad);
    }

    @Override
    public List<Universidad> findBynombreUniversidad(String nombreUniversidad) {
        return uR.findBynombreUniversidad_nombreUniversidad(nombreUniversidad);
    }
}

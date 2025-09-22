package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Categoria;
import pe.edu.upc.code_civitrack.entities.Ubicacion;
import pe.edu.upc.code_civitrack.repositories.ICategoriaRepository;
import pe.edu.upc.code_civitrack.repositories.IUbicacionRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.ICategoriaService;

import java.util.List;


@Service
public class CategoriaServiceImplement implements ICategoriaService {

    @Autowired
    private ICategoriaRepository cR;

    @Override
    public void insert(Categoria c) {
        cR.save(c);
    }

    @Override
    public List<Categoria> list() {
        return cR.findAll();
    }
}

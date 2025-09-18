package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Estudiante;
import pe.edu.upc.code_civitrack.repositories.IEstudianteRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IEstudianteService;

import java.util.List;

@Service
public class EstudianteServiceImplement implements IEstudianteService {
    @Autowired
    private IEstudianteRepository eR;

    @Override
    public List<Estudiante> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Estudiante estudiante) {
        eR.save(estudiante);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public Estudiante listId(int id) {
        return eR.findById(id).orElse(null);
    }

    @Override
    public void update(Estudiante estudiante) {
        eR.save(estudiante);
    }

    @Override
    public Estudiante findBycodigoEstudiante(String codigoEstudiante) {
        return eR.findBycodigoEstudiante_codigoEstudiante(codigoEstudiante);
    }

    @Override
    public List<Estudiante> findBycarreraEstudiante(String carreraEstudiante) {
        return eR.findBycarreraEstudiante_carreraEstudiante(carreraEstudiante);
    }
}

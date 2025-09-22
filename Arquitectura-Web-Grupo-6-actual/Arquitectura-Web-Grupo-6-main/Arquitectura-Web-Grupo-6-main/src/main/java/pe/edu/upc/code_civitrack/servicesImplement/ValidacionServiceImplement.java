package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Validacion;
import pe.edu.upc.code_civitrack.repositories.IValidacionRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IValidacionService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ValidacionServiceImplement implements IValidacionService {
    @Autowired
    private IValidacionRepository vR;

    @Override
    public List<Validacion> list() {
        return vR.findAll();
    }

    @Override
    public void insert(Validacion validacion) {
        vR.save(validacion);
    }

    @Override
    public void delete(int id) {
        vR.deleteById(id);
    }

    @Override
    public Validacion listId(int id) {
        return vR.findById(id).orElse(null);
    }

    @Override
    public void update(Validacion validacion) {
        vR.save(validacion);
    }

    @Override
    public List<Validacion> buscarService(LocalDate fecha) {
        return vR.buscarPorFecha(fecha);
    }
}

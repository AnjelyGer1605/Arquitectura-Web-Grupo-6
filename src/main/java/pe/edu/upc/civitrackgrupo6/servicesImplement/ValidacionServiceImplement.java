package pe.edu.upc.civitrackgrupo6.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.civitrackgrupo6.entities.Validacion;
import pe.edu.upc.civitrackgrupo6.repositories.IValidacionRepository;
import pe.edu.upc.civitrackgrupo6.servicesInterfaces.IValidacionService;

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
    public List<Validacion> findValidacionesPorReporte(Long idReporte) {
        return vR.findValidacionesPorReporte(idReporte);
    }
}

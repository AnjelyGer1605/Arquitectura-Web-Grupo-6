package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.code_civitrack.entities.Solicitud;
import pe.edu.upc.code_civitrack.repositories.ISolicitudRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.ISolicitudService;

import java.util.List;

public class SolicitudServiceImplement implements ISolicitudService {
    @Autowired
    private ISolicitudRepository sR;

    @Override
    public List<Solicitud> list() {
        return sR.findAll();
    }

    @Override
    public void insert(Solicitud solicitud) {

    }

    @Override
    public void insert(Solicitud solicitud) {
        sR.save(solicitud);
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public Solicitud listId(int id) {
        return sR.findById(id).orElse(null);
    }

    @Override
    public void update(Solicitud solicitud) {
        sR.save(solicitud);
    }
}

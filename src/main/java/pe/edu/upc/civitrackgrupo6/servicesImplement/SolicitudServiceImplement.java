package pe.edu.upc.civitrackgrupo6.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.upc.civitrackgrupo6.entities.Solicitud;
import pe.edu.upc.civitrackgrupo6.repositories.ISolicitudRepository;
import pe.edu.upc.civitrackgrupo6.servicesInterfaces.ISolicitudService;

import java.util.List;

@Service
public class SolicitudServiceImplement implements ISolicitudService {
    @Autowired
    private ISolicitudRepository sR;

    @Override
    public List<Solicitud> list() {
        return sR.findAll();
    }

    @Override
    public void insert(Solicitud solicitud) {
        sR.save(solicitud);
    }

    @Override
    public void delete(int id) {
        if (sR.existsById(id)) {
            sR.deleteById(id);
        }
    }

    @Override
    public Solicitud listId(int id) {
        return sR.findById(id).orElse(null);
    }

    @Override
    public void update(Solicitud solicitud) {
        sR.save(solicitud);
    }

    @Override
    public List<Solicitud> findSolicitudesPorEstado(String estado) {
        return sR.findSolicitudesPorEstado(estado);
    }

}

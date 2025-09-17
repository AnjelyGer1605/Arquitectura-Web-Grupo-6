package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Notificacion;
import pe.edu.upc.code_civitrack.repositories.INotificacionRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.INotificacionService;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {
    @Autowired
    private INotificacionRepository nR;

    @Override
    public List<Notificacion> list() {
        return nR.findAll();
    }

    @Override
    public void insert(Notificacion notificacion) {
        nR.save(notificacion);
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

    @Override
    public Notificacion listId(int id) {
        return nR.findById(id).orElse(null);
    }

    @Override
    public void update(Notificacion notificacion) {
        nR.save(notificacion);
    }

    @Override
    public List<Notificacion> buscarService(LocalDate fecha) {
        return nR.buscarPorFecha(fecha);
    }
}


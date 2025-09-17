package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Ubicacion;
import pe.edu.upc.code_civitrack.repositories.IUbicacionRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IUbicacionService;

import java.util.List;

@Service
public class UbicacionServiceImplement implements IUbicacionService {


    @Autowired
    private IUbicacionRepository uR;

    @Override
    public void insert(Ubicacion ubicacion) {
        uR.save( ubicacion);
    }

    @Override
    public List<Ubicacion> list() {
        return uR.findAll();
    }
}

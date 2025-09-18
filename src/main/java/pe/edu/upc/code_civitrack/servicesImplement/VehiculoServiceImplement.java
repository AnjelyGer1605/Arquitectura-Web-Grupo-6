package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Vehiculo;
import pe.edu.upc.code_civitrack.repositories.IVehiculoRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IVehiculoService;

import java.util.List;

@Service
public class VehiculoServiceImplement implements IVehiculoService {
    @Autowired
    private IVehiculoRepository vR;

    @Override
    public List<Vehiculo> list() {
        return vR.findAll();
    }

    @Override
    public void insert(Vehiculo vehiculo) {
        vR.save(vehiculo);
    }

    @Override
    public void delete(int id) {
        vR.deleteById(id);
    }

    @Override
    public Vehiculo listId(int id) {
        return vR.findById(id).orElse(null);
    }

    @Override
    public void update(Vehiculo vehiculo) {
        vR.save(vehiculo);
    }

    @Override
    public Vehiculo findByplacaVehiculo(String placaVehiculo) {
        return vR.findByplacaVehiculo_placaVehiculo(placaVehiculo);
    }

    @Override
    public List<Vehiculo> findBymarcaVehiculo(String marcaVehiculo) {
        return vR.findBymarcaVehiculo_marcaVehiculo(marcaVehiculo);
    }
}

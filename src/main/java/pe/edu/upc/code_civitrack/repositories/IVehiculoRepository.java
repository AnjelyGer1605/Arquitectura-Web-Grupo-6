package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Vehiculo;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    Vehiculo findByplacaVehiculo_placaVehiculo(String placaVehiculo);
    List<Vehiculo> findBymarcaVehiculo_marcaVehiculo(String marcaVehiculo);
}

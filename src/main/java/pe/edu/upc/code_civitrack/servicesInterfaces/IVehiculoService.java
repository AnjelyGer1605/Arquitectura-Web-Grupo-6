package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> list();
    void insert(Vehiculo vehiculo);
    void delete(int id);
    Vehiculo listId(int id);
    void update(Vehiculo vehiculo);

    Vehiculo findByplacaVehiculo(String placaVehiculo);
    List<Vehiculo> findBymarcaVehiculo(String marcaVehiculo);

    Vehiculo findByPlacaVehiculo(String placaVehiculo);

    List<Vehiculo> findByMarcaVehiculo(String marcaVehiculo);
}

package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    public List<Vehiculo> list();
    public void insert(Vehiculo vehiculo);
    public void delete(int id);
    public Vehiculo listId(int id);
    public void update(Vehiculo vehiculo);

    Vehiculo findByplacaVehiculo(String placaVehiculo);
    public List<Vehiculo> findBymarcaVehiculo(String marcaVehiculo);

}

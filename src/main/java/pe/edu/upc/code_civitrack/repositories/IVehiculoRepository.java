package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Vehiculo;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query("SELECT v FROM Vehiculo v WHERE v.placaVehiculo = :placaVehiculo")
    Vehiculo buscarPorPlaca(@Param("placaVehiculo") String placaVehiculo);

    @Query("SELECT v FROM Vehiculo v WHERE v.marcaVehiculo = :marcaVehiculo")
    List<Vehiculo> buscarPorMarca(@Param("marcaVehiculo") String marcaVehiculo);

}

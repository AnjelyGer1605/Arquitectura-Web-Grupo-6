package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Ubicacion;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IUbicacionRepository extends JpaRepository<Ubicacion,Integer> {

    // Buscar ubicaciones exactas por latitud y longitud
    @Query("SELECT u FROM Ubicacion u WHERE u.latitud = :latitud AND u.longitud = :longitud")
    List<Ubicacion> buscarPorCoordenadas(@Param("latitud") double latitud, @Param("longitud") double longitud);
}

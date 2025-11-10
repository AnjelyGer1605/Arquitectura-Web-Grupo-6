package pe.edu.upc.civitrackgrupo6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.civitrackgrupo6.entities.Solicitud;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ISolicitudRepository extends JpaRepository<Solicitud,Integer> {

    // US47 – Consultar solicitudes por estado
    @Query("SELECT s FROM Solicitud s WHERE s.estado = :estado ORDER BY s.fechaEnvio DESC")
    List<Solicitud> findSolicitudesPorEstado(@Param("estado") String estado);
}


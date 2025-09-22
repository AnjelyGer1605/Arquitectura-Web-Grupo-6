package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.code_civitrack.entities.Solicitud;

import java.time.LocalDateTime;
import java.util.List;

public interface ISolicitudRepository extends JpaRepository<Solicitud,Integer> {

    @Query("SELECT s FROM Solicitud s WHERE s.usuario.idUsuario = :idUsuario")
    List<Solicitud> buscarPorUsuario(@Param("idUsuario") int idUsuario);

    @Query("SELECT s FROM Solicitud s WHERE s.fechaEnvio = :fecha")
    List<Solicitud> buscarPorFecha(@Param("fecha") LocalDateTime fecha);

    @Query("SELECT s FROM Solicitud s WHERE s.reporte.idReporte = :idReporte")
    List<Solicitud> buscarPorReporte(@Param("idReporte") int idReporte);
}

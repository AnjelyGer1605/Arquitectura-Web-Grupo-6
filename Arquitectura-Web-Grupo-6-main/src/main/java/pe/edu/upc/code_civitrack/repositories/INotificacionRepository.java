package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Notificacion;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {

    @Query("SELECT n FROM Notificacion n WHERE n.fechaEnvio = :fecha")
    List<Notificacion> buscarPorFecha(@Param("fecha") LocalDate fecha);

    @Query("SELECT n FROM Notificacion n WHERE n.usuario.idUsuario = :idUsuario")
    List<Notificacion> buscarPorUsuario(@Param("idUsuario") int idUsuario);

}
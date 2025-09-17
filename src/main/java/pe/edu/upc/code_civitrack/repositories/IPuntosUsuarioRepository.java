package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.code_civitrack.entities.PuntosUsuario;

import java.time.LocalDateTime;
import java.util.List;

public interface IPuntosUsuarioRepository extends JpaRepository<PuntosUsuario,Integer> {
    @Query("SELECT p FROM PuntosUsuario p WHERE p.usuario.idUsuario = :idUsuario")
    List<PuntosUsuario> buscarPorUsuario(@Param("idUsuario") int idUsuario);

    // Buscar puntos que expiran después de cierta fecha
    @Query("SELECT p FROM PuntosUsuario p WHERE p.fechaCaducidad > :fecha")
    List<PuntosUsuario> buscarPorFechaCaducidad(@Param("fecha") LocalDateTime fecha);
}

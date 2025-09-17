package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Validacion;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IValidacionRepository extends JpaRepository<Validacion, Integer> {

    @Query("SELECT v FROM Validacion v WHERE v.fechaValidacion = :fecha")
    List<Validacion> buscarPorFecha(@Param("fecha") LocalDate fecha);

    @Query("SELECT v FROM Validacion v WHERE v.usuario.idUsuario = :idUsuario")
    List<Validacion> buscarPorUsuario(@Param("idUsuario") int idUsuario);
}
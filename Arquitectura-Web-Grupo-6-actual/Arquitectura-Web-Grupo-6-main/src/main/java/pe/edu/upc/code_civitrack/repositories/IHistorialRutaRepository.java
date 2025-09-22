package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.HistorialRuta;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IHistorialRutaRepository extends JpaRepository<HistorialRuta, Integer> {

    @Query("SELECT h FROM HistorialRuta h WHERE h.fecha = :fecha")
    List<HistorialRuta> buscarPorFecha(@Param("fecha") LocalDate fecha);

    @Query("SELECT h FROM HistorialRuta h WHERE h.ruta.idruta = :idRuta")
    List<HistorialRuta> buscarPorRuta(@Param("idRuta") int idRuta);
}
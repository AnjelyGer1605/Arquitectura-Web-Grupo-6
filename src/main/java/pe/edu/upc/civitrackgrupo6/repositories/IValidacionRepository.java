package pe.edu.upc.civitrackgrupo6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.civitrackgrupo6.entities.Validacion;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IValidacionRepository extends JpaRepository<Validacion, Integer> {

    // US37 – Validaciones por reporte
    @Query("SELECT v FROM Validacion v WHERE v.reporte.idReporte = :idReporte")
    List<Validacion> findValidacionesPorReporte(@Param("idReporte") Long idReporte);
}
package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Reporte;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReporteRepository extends JpaRepository<Reporte, Integer> {

    @Query("Select a from Reporte a where a.fechaHora=:fecha")
    public List<Reporte> buscar(@Param("fecha") LocalDate fecha);

}

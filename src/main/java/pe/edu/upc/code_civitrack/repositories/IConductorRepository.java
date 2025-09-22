package pe.edu.upc.demotrabajocivitrak.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demotrabajocivitrak.Entities.Conductor;

@Repository
public interface IConductorRepository extends JpaRepository<Conductor,Long> {
}

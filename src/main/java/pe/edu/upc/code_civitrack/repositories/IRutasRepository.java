package pe.edu.upc.demotrabajocivitrak.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demotrabajocivitrak.Entities.Rutas;

@Repository
public interface IRutasRepository extends JpaRepository<Rutas,Integer> {
}

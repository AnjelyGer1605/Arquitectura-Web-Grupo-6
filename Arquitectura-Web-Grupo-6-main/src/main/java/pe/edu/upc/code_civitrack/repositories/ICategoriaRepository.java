package pe.edu.upc.code_civitrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.code_civitrack.entities.Categoria;
@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria,Integer>{
}

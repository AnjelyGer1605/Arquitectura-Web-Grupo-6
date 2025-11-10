package pe.edu.upc.civitrackgrupo6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.civitrackgrupo6.entities.Usuario;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    // US25 – Autenticación (login con JWT)
    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo")
    Usuario findByCorreo(@Param("correo") String correo);

    // US28 – Validar duplicado de correo
    @Query("SELECT COUNT(u) > 0 FROM Usuario u WHERE u.correo = :correo")
    boolean existsByCorreo(@Param("correo") String correo);

}

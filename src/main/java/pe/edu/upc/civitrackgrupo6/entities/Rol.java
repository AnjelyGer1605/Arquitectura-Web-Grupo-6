package pe.edu.upc.civitrackgrupo6.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "rol"})})
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rol;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}

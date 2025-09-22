package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Conductor")
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    private String nombre;

    public Conductor() {
    }

    public Conductor(int id, Usuario usuario, String nombre) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public Conductor(int id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

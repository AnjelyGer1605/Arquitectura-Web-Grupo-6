package pe.edu.upc.demotrabajocivitrak.Entities;

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

    public Conductor() {
    }

    public Conductor(int id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
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

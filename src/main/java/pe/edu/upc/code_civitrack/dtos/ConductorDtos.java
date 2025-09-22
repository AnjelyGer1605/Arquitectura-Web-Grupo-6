package pe.edu.upc.code_civitrack.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.code_civitrack.entities.Usuario;

public class ConductorDtos {

    private int id;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

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

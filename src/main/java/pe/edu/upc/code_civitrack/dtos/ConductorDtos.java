package pe.edu.upc.demotrabajocivitrak.Dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.demotrabajocivitrak.Entities.Usuario;

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

package pe.edu.upc.demotrabajocivitrak.Dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.demotrabajocivitrak.Entities.Usuario;

import java.time.LocalDateTime;

public class RutasDtos {
    private int idruta;
    private String nombreruta;
    private String latitudorigen;
    private String latituddestino;
    private String longitudorigen;
    private String longituddestino;
    private LocalDateTime fechacreacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public LocalDateTime getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDateTime fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public String getLatituddestino() {
        return latituddestino;
    }

    public void setLatituddestino(String latituddestino) {
        this.latituddestino = latituddestino;
    }

    public String getLatitudorigen() {
        return latitudorigen;
    }

    public void setLatitudorigen(String latitudorigen) {
        this.latitudorigen = latitudorigen;
    }

    public String getLongituddestino() {
        return longituddestino;
    }

    public void setLongituddestino(String longituddestino) {
        this.longituddestino = longituddestino;
    }

    public String getLongitudorigen() {
        return longitudorigen;
    }

    public void setLongitudorigen(String longitudorigen) {
        this.longitudorigen = longitudorigen;
    }

    public String getNombreruta() {
        return nombreruta;
    }

    public void setNombreruta(String nombreruta) {
        this.nombreruta = nombreruta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

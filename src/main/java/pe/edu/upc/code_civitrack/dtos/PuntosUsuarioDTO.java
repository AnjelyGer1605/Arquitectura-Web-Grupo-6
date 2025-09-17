package pe.edu.upc.code_civitrack.dtos;

import java.time.LocalDateTime;

public class PuntosUsuarioDTO {
    private int idPuntos;
    private int puntosTotal;
    private String nivelActual;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCaducidad;
    private Usuario usuario;

    public int getIdPuntos() {
        return idPuntos;
    }

    public void setIdPuntos(int idPuntos) {
        this.idPuntos = idPuntos;
    }

    public int getPuntosTotal() {
        return puntosTotal;
    }

    public void setPuntosTotal(int puntosTotal) {
        this.puntosTotal = puntosTotal;
    }

    public String getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(String nivelActual) {
        this.nivelActual = nivelActual;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

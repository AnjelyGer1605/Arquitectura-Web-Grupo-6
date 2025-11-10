package pe.edu.upc.civitrackgrupo6.dtos;

import java.time.LocalDateTime;

public class ValidacionDTO {
    private int idValidacion;
    private LocalDateTime fechaValidacion;
    private String estado;
    private String comentario;
    private int cantidadValidaciones;
    private int idUsuario;
    private int idReporte;

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdValidacion() {
        return idValidacion;
    }

    public void setIdValidacion(int idValidacion) {
        this.idValidacion = idValidacion;
    }

    public LocalDateTime getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(LocalDateTime fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadValidaciones() {
        return cantidadValidaciones;
    }

    public void setCantidadValidaciones(int cantidadValidaciones) {
        this.cantidadValidaciones = cantidadValidaciones;
    }



    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}

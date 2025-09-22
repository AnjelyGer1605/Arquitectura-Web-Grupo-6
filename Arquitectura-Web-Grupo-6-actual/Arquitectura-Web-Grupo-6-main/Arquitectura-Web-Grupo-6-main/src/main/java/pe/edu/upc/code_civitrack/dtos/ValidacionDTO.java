package pe.edu.upc.code_civitrack.dtos;

import java.time.LocalDate;

public class ValidacionDTO {
    private int validacionId;
    private LocalDate fechaValidacion;
    private String estado;
    private int cantidadValidaciones;
    private int reporteId;
    private int usuarioId;

    public int getValidacionId() {
        return validacionId;
    }

    public void setValidacionId(int validacionId) {
        this.validacionId = validacionId;
    }

    public LocalDate getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(LocalDate fechaValidacion) {
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

    public int getReporteId() {
        return reporteId;
    }

    public void setReporteId(int reporteId) {
        this.reporteId = reporteId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}

package pe.edu.upc.code_civitrack.dtos;

import java.time.LocalDate;

public class NotificacionDTO {
    private int notificacionId;
    private String mensaje;
    private LocalDate fechaEnvio;
    private int reporteId;
    private int usuarioId;

    public int getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(int notificacionId) {
        this.notificacionId = notificacionId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
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
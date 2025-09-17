package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Validaciones")
public class Validacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_validacion")
    private int idValidacion;

    @Column(name = "fecha_validacion", nullable = false)
    private LocalDateTime fechaValidacion;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "cantidad_validaciones", nullable = false)
    private int cantidadValidaciones;

    @ManyToOne
    @JoinColumn(name = "reporte_id", nullable = false)
    private Reporte reporte;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Validacion() {}

    public Validacion(int idValidacion, LocalDateTime fechaValidacion, String estado, int cantidadValidaciones, Reporte reporte, Usuario usuario) {
        this.idValidacion = idValidacion;
        this.fechaValidacion = fechaValidacion;
        this.estado = estado;
        this.cantidadValidaciones = cantidadValidaciones;
        this.reporte = reporte;
        this.usuario = usuario;
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

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

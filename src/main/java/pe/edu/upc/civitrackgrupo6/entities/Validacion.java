package pe.edu.upc.civitrackgrupo6.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Validaciones")
public class Validacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idValidacion")
    private int idValidacion;

    @Column(name = "fechaValidacion", nullable = false)
    private LocalDateTime fechaValidacion;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "cantidadValidaciones", nullable = false)
    private int cantidadValidaciones;

    @Column(name = "comentario", length = 500)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idReporte")
    private Reporte reporte;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Validacion() {}


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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Validacion(int idValidacion, LocalDateTime fechaValidacion, String estado, int cantidadValidaciones, String comentario, Reporte reporte, Usuario usuario) {
        this.idValidacion = idValidacion;
        this.fechaValidacion = fechaValidacion;
        this.estado = estado;
        this.cantidadValidaciones = cantidadValidaciones;
        this.comentario = comentario;
        this.reporte = reporte;
        this.usuario = usuario;

    }

}

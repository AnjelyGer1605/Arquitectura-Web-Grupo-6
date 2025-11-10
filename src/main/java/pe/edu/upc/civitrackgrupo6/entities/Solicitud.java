package pe.edu.upc.civitrackgrupo6.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Solicitud")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSolicitud")
    private int idSolicitud;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "rol", nullable = false, length = 30)
    private String rol;

    @Column(name = "mensaje", length = 250)
    private String mensaje;

    @Column(name = "fechaEnvio", nullable = false)
    private LocalDateTime fechaEnvio;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "documentoId")
    private Tipodocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idReporte")
    private Reporte reporte;

    public Solicitud() {}

    public Solicitud(int idSolicitud, String nombre, String apellidos, String telefono, String correo, String rol, String mensaje, LocalDateTime fechaEnvio, String estado, Tipodocumento tipoDocumento, Usuario usuario, Reporte reporte) {
        this.idSolicitud = idSolicitud;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.rol = rol;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
        this.usuario = usuario;
        this.reporte = reporte;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Tipodocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Tipodocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

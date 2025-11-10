package pe.edu.upc.civitrackgrupo6.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idUsuario")
    private int idUsuario;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name="correo", nullable = false, length = 50)
    private String correo;
    @Column(name="password", nullable = false, length = 200)
    private String password;
    @Column(name="rol", nullable = false, length = 50)
    private String rol;
    @Column(name="fechaRegistro", nullable = false)
    private LocalDateTime fechaRegistro;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Conductor conductor;

    public Usuario() {
    }

    public Usuario(String correo, LocalDateTime fecharegistro, int idUsuario, String nombre, String password, String rol) {
        this.correo = correo;
        this.fechaRegistro = fecharegistro;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getFecharegistro() {
        return fechaRegistro;
    }

    public void setFecharegistro(LocalDateTime fecharegistro) {
        this.fechaRegistro = fecharegistro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

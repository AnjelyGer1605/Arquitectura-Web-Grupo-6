package pe.edu.upc.civitrackgrupo6.dtos;


import java.time.LocalDateTime;


public class UsuarioDtos {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String password;
    private String rol;
    private LocalDateTime fechaRegistro;

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


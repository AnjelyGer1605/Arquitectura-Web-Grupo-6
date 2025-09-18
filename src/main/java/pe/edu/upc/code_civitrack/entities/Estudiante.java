package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;

    @Column(name = "codigoEstudiante", nullable = false)
    private String codigoEstudiante;

    @Column(name = "codigoEstudiante", nullable = false)
    private String carreraEstudiante;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "añoIngresoEstudiante", nullable = false)
    private int añoIngresoEstudiante;


    public Estudiante() {

    }

    public Estudiante(int idEstudiante, String codigoEstudiante, String carreraEstudiante, Usuario usuario, int añoIngresoEstudiante) {
        this.idEstudiante = idEstudiante;
        this.codigoEstudiante = codigoEstudiante;
        this.carreraEstudiante = carreraEstudiante;
        this.usuario = usuario;
        this.añoIngresoEstudiante = añoIngresoEstudiante;
    }



    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCarreraEstudiante() {
        return carreraEstudiante;
    }

    public void setCarreraEstudiante(String carreraEstudiante) {
        this.carreraEstudiante = carreraEstudiante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getAñoIngresoEstudiante() {
        return añoIngresoEstudiante;
    }

    public void setAñoIngresoEstudiante(int añoIngresoEstudiante) {
        this.añoIngresoEstudiante = añoIngresoEstudiante;
    }
}
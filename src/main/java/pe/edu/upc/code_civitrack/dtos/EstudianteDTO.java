package pe.edu.upc.code_civitrack.dtos;


public class EstudianteDTO {

    private int idEstudiante;

    private String codigoEstudiante;

    private String carreraEstudiante;

    private int idUsuario;

    private int añoIngresoEstudiante;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getAñoIngresoEstudiante() {
        return añoIngresoEstudiante;
    }

    public void setAñoIngresoEstudiante(int añoIngresoEstudiante) {
        this.añoIngresoEstudiante = añoIngresoEstudiante;
    }
}

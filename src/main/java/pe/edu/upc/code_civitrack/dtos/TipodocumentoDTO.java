package pe.edu.upc.code_civitrack.dtos;

public class TipodocumentoDTO {
    private int documentoId;
    private String nombre;

    public int getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(int documentoId) {
        this.documentoId = documentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

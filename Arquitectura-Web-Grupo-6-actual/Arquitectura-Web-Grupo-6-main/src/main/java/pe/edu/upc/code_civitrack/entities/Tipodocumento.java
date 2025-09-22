package pe.edu.upc.code_civitrack.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoDocumento")
public class Tipodocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documento_id")
    private int documentoId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    public Tipodocumento() {}

    public Tipodocumento(int documentoId, String nombre) {
        this.documentoId = documentoId;
        this.nombre = nombre;
    }

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

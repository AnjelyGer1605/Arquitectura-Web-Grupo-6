package pe.edu.upc.civitrackgrupo6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoDocumento")
public class Tipodocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentoId")
    private int documentoId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    public Tipodocumento() {}


    public Tipodocumento(int documentoId, String nombre, String estado) {
        this.documentoId = documentoId;
        this.nombre = nombre;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

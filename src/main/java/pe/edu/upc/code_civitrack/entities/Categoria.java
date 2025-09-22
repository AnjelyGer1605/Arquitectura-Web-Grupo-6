package pe.edu.upc.code_civitrack.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;

    @Column(name = "tipo",length =10 ,nullable = false)
    private String tipo;

    private String nombre;
    public Categoria() {
    }

    public Categoria(int idCategoria, String tipo, String nombre) {
        this.idCategoria = idCategoria;
        this.tipo = tipo;
        this.nombre = nombre;
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

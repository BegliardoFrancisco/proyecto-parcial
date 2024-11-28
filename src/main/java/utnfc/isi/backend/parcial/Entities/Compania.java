package utnfc.isi.backend.parcial.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Companias")
public class Compania {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compania_id")
    int id;

    String nombre;

    double comision;


    public Compania(String nombre, double comision) {
        this.nombre = nombre;
        this.comision = comision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Compania() {

    }

    @Override
    public String toString() {
        return "{" +
                "\nid:" + id +
                ",\nnombre: " + nombre +
                ",\ncomision: " + comision +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compania compania = (Compania) o;
        return Objects.equals(nombre, compania.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}

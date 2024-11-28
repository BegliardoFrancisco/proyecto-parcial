package utnfc.isi.backend.parcial.Entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "OperadoresTarjetas")
public class OperadorTarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operador_id")
    int id;

    String nombre;

    @OneToMany(mappedBy = "operadorTarjeta", fetch = FetchType.LAZY)
    List<Cuenta> cuentas;

    public OperadorTarjeta(String nombre) {
        this.nombre = nombre;
    }

    public OperadorTarjeta() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperadorTarjeta that = (OperadorTarjeta) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "OperadorTarjeta{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

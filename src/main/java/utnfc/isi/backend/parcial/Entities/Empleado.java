package utnfc.isi.backend.parcial.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Empleados")
public class Empleado {

    @Column(name = "empleado_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nombre;

    String identificador;

    String telefono;

    @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "comania_id", referencedColumnName = "compania_id")
    Compania compania;

    public Empleado(String nombre,String identificador, String telefono, Compania compania) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.telefono = telefono;
        this.compania = compania;
    }

    public Empleado() {

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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", telefono='" + telefono + '\'' +
                ", identificador='" + identificador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", compania=" + compania +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(nombre, empleado.nombre) && Objects.equals(telefono, empleado.telefono) && Objects.equals(compania, empleado.compania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono, compania);
    }
}

package utnfc.isi.backend.parcial.Entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Monedass")
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moneda_id")
    int id;

    String nombre;

    @Column(name = "conversion_usd")
    float conversionUSD;

    @OneToMany(mappedBy = "moneda", fetch = FetchType.LAZY)
    List<Cuenta> cuentas;

    public Moneda(float conversionUSD, String nombre) {
        this.conversionUSD = conversionUSD;
        this.nombre = nombre;
    }

    public Moneda() {

    }

    @Override
    public String toString() {
        return "Moneda{" +
                "nombre='" + nombre + '\'' +
                ", conversionUSD=" + conversionUSD +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moneda moneda = (Moneda) o;
        return Float.compare(conversionUSD, moneda.conversionUSD) == 0 && Objects.equals(nombre, moneda.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, conversionUSD);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getConversionUSD() {
        return conversionUSD;
    }

    public void setConversionUSD(float conversionUSD) {
        this.conversionUSD = conversionUSD;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

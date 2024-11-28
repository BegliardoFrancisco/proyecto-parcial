package utnfc.isi.backend.parcial.Entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cuenta _id")
    Integer id;

    @Column(name="numero_cuenta")
    String numeroCuenta;

    @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name="empleado_id", referencedColumnName = "empleado_id")
    Empleado empleado;

    @Column(name="numero_tarjeta")
    String numeroTarjeta;

    @Column(name="vencimiento_tarjeta")
    String vencimiento_tarjeta;


    @ManyToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "emprea_tarjeta_id", referencedColumnName = "operador_id")
    OperadorTarjeta operadorTarjeta;

    @ManyToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "moneda_id", referencedColumnName = "moneda_id")
    Moneda moneda;

    double saldo;

    public Cuenta(String numeroCuenta, Empleado empleado, String numeroTarjeta, String vencimiento_tarjeta, OperadorTarjeta operadorTarjeta, Moneda moneda, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.empleado = empleado;
        this.numeroTarjeta = numeroTarjeta;
        this.vencimiento_tarjeta = vencimiento_tarjeta;
        this.operadorTarjeta = operadorTarjeta;
        this.moneda = moneda;
        this.saldo = saldo;
    }

    public Cuenta() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getVencimiento_tarjeta() {
        return vencimiento_tarjeta;
    }

    public void setVencimiento_tarjeta(String vencimiento_tarjeta) {
        this.vencimiento_tarjeta = vencimiento_tarjeta;
    }

    public OperadorTarjeta getOperadorTarjeta() {
        return operadorTarjeta;
    }

    public void setOperadorTarjeta(OperadorTarjeta operadorTarjeta) {
        this.operadorTarjeta = operadorTarjeta;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

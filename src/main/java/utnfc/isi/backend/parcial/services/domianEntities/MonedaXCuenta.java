package utnfc.isi.backend.parcial.services.domianEntities;

import utnfc.isi.backend.parcial.Entities.Cuenta;
import utnfc.isi.backend.parcial.Entities.Moneda;

public class MonedaXCuenta {

    private String moneda;
    private Long cantidad;
    private double total;


    public MonedaXCuenta(Moneda moneda) {

        this.moneda = moneda.getNombre();
        this.cantidad = moneda.getCuentas().stream().count();
        this.total = moneda.getCuentas()
                .stream()
                .map(Cuenta::getSaldo)
                .reduce(0.0, Double::sum);

    }

    @Override
    public String toString() {
        return "CUENTA | CANTIDAD | MONTO" +
                "\n{" +
                "\ntotal:" + total +
                ",\ncantidad:" + cantidad +
                ",\nmoneda:" + moneda +
                "\n}";
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }



}

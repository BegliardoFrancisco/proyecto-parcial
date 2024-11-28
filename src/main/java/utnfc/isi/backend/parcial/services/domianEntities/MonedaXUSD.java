package utnfc.isi.backend.parcial.services.domianEntities;

import utnfc.isi.backend.parcial.Entities.Cuenta;
import utnfc.isi.backend.parcial.Entities.Moneda;

public class MonedaXUSD {
    String nombre;
    double valor;


    public MonedaXUSD(Moneda moneda) {
        this.nombre = moneda.getNombre();
        long cantidad = moneda.getCuentas().stream().count();
        this.valor = (
                moneda.getCuentas()
                .stream()
                .map(Cuenta::getSaldo)
                .reduce(0.0, Double::sum)
        ) * (moneda.getConversionUSD());

    }

    public MonedaXUSD() {
        this.valor = 0.0;
        this.nombre = "XXXXXX";
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "CUENTA | MONTO" +
                "\n{" +
                ",\nmoneda: " + nombre +
                "\ntotal: $USD " + valor +
                "\n}";
    }
}

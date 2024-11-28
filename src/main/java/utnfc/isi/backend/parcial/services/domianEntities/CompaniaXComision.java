package utnfc.isi.backend.parcial.services.domianEntities;

import utnfc.isi.backend.parcial.Entities.Cuenta;

import java.util.HashMap;
import java.util.List;

public class CompaniaXComision {

    private HashMap<String,Double> mapa;




    public CompaniaXComision(List<Cuenta> cuentas ){
        mapa = new HashMap<String,Double>();

        cuentas.forEach(cuenta -> {
            String nombre = cuenta.getEmpleado().getCompania().getNombre();
            double comision = cuenta.getEmpleado().getCompania().getComision();
            double saldo = cuenta.getSaldo();
            double usdConvercion = cuenta.getMoneda().getConversionUSD();
            double valor = (saldo* usdConvercion) * comision;
            if (mapa.containsKey(nombre)) {
                mapa.put(nombre, mapa.get(nombre) +  valor);
            } else {
                mapa.put(nombre, valor);
            }
        });

    }

    @Override
    public String toString() {
        StringBuilder stringTo = new StringBuilder();
        for (String key : mapa.keySet()) {
            stringTo.append("{").append(key).append(": $").append(mapa.get(key).toString()).append("}\n");
        }
        return stringTo.toString();
    }
}

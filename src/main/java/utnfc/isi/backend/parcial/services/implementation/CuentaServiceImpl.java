package utnfc.isi.backend.parcial.services.implementation;

import utnfc.isi.backend.parcial.Entities.*;
import utnfc.isi.backend.parcial.Repositories.implementations.CuentaRepositoryImpl;
import utnfc.isi.backend.parcial.services.interfaces.CompaniaService;
import utnfc.isi.backend.parcial.services.interfaces.CuentaService;
import utnfc.isi.backend.parcial.services.interfaces.MonedaService;
import utnfc.isi.backend.parcial.services.interfaces.OperadorTarjetaService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CuentaServiceImpl extends ServiceImpl<Cuenta,Integer> implements CuentaService {

    private CompaniaServiceImpl companiaService;
    private MonedaServiceImpl monedaService;
    private OperadorTarjetaServiceImpl operadorTarjetaService;
    private EmpleadoServiceImpl empleadoService;

   public CuentaServiceImpl() {
       repository = new CuentaRepositoryImpl();
       this.companiaService = new CompaniaServiceImpl();
       this.monedaService = new MonedaServiceImpl();
       this.empleadoService = new EmpleadoServiceImpl();
       this.operadorTarjetaService = new OperadorTarjetaServiceImpl();

   }


    @Override
    public void bulkinsert(URL location) throws URISyntaxException, IOException {

        HashSet<Cuenta> cuentas = Files.lines(Paths.get(location.toURI()))
                .skip(1)
                .map(this::parseData)
                .collect(Collectors.toCollection(HashSet::new));

        cuentas.forEach(cuenta -> repository.add(cuenta));
    }

    private Cuenta parseData(String line) {

       String[] items = line.split("\\|");

       Empleado empleadoCompania = this.empleadoService.parseData(line);

       Empleado empleado = this.empleadoService
               .findAll()
               .stream()
               .filter(e -> e.equals(empleadoCompania))
               .findFirst()
               .orElse(null);

       if (empleado == null) {
         System.out.println("Cuenta no asiganda a un empleado");
       }

       Moneda monedaCompania = this.monedaService.parserValue(line);

       Moneda moneda = this.monedaService
               .findAll()
               .stream()
               .filter(m -> m.equals(monedaCompania))
               .findFirst()
               .orElse(null);

       if (moneda == null) {
           System.out.println("Cuenta no asiganda a una moneda");
       }

       OperadorTarjeta operadorTarjetaCompania = this.operadorTarjetaService.parseValue(line);

       OperadorTarjeta operadorTarjeta = this.operadorTarjetaService
               .findAll()
               .stream()
               .filter(o -> o.equals(operadorTarjetaCompania))
               .findFirst()
               .orElse(null);

       if (operadorTarjeta == null) {
           System.out.println("Cuenta no asiganda a un operador de tarjeta");
       }

       String numero_cta = items[5];
       String numero_tarjeta = items[6];
       String vencimiento = items[8];
       double saldo = Double.parseDouble(items[9]);

        return new Cuenta(numero_cta, empleado, numero_tarjeta, vencimiento,operadorTarjeta, moneda,saldo);

    }


}

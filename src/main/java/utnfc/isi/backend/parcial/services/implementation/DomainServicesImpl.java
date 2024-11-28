package utnfc.isi.backend.parcial.services.implementation;

import utnfc.isi.backend.parcial.Entities.Cuenta;
import utnfc.isi.backend.parcial.Entities.Moneda;
import utnfc.isi.backend.parcial.services.domianEntities.CompaniaXComision;
import utnfc.isi.backend.parcial.services.domianEntities.MonedaXCuenta;
import utnfc.isi.backend.parcial.services.domianEntities.MonedaXUSD;
import utnfc.isi.backend.parcial.services.interfaces.CuentaService;
import utnfc.isi.backend.parcial.services.interfaces.MonedaService;
import utnfc.isi.backend.parcial.services.interfaces.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class DomainServicesImpl {

    private MonedaService monedaService;
    private CuentaService cuentaService;

    public DomainServicesImpl(){
        this.monedaService = new MonedaServiceImpl();
        this.cuentaService = new CuentaServiceImpl();
    }


    public static void toInserts(Service service, URL location) {
        boolean countData = !service.countData();

        if (countData) {
            try {
                service.bulkinsert(location);
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        service.findAll().forEach(System.out::println);

    }


    public List<MonedaXCuenta> ReporteCuentasxMonedas() {
        return this.monedaService
                .findAll()
                .stream()
                .map(MonedaXCuenta::new)
                .sorted(Comparator.comparing(MonedaXCuenta::getCantidad))
                .toList();
    }

    public MonedaXUSD ReporteMonedaXMontoUSD() {
        return this.monedaService
                .findAll()
                .stream()
                .map(MonedaXUSD::new)
                .max(Comparator.comparing(MonedaXUSD::getValor))
                .orElse(new MonedaXUSD());
    }

    public void companiaXComision() {

        HashMap<String, Double> mapa = new HashMap<String, Double>();
        List<Cuenta> cuentas = this.cuentaService.findAll();

        CompaniaXComision companiaXComision= new CompaniaXComision(cuentas);

        guardarObjetoEnArchivo(companiaXComision);
    }

    public static void guardarObjetoEnArchivo(CompaniaXComision companiaXComision) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("comision.txt");
            fileWriter.write(companiaXComision.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

package utnfc.isi.backend.parcial;


import utnfc.isi.backend.parcial.services.domianEntities.MonedaXCuenta;
import utnfc.isi.backend.parcial.services.domianEntities.MonedaXUSD;
import utnfc.isi.backend.parcial.services.implementation.DomainServicesImpl;

import java.io.File;
import java.net.URL;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File("data/operaciones.csv");

        // Verifica si el archivo existe
        if (file.exists()) {
            System.out.println("Ruta del archivo: " + file.getAbsolutePath());
        } else {
            System.out.println("El archivo operaciones.csv no fue encontrado.");
        }

        URL location = file.toURI().toURL();
        DomainServicesImpl requerimientos = new DomainServicesImpl();


        // REQUERIMIENTOS DEL DOMINIO

        // PUNTO 1 CARGAR LOS DATOS DESDE EL CSV HASTA LA BDD


        // PUNTO 2

        System.out.println("PUNTO 2\n");
        List<MonedaXCuenta> monedaXCuentList = requerimientos.ReporteCuentasxMonedas();

        monedaXCuentList.forEach(System.out::println);

        //PUNTO 4

        System.out.println("PUNTO 4\n");
        MonedaXUSD monedaXUSD = requerimientos.ReporteMonedaXMontoUSD();

        System.out.println(monedaXUSD.toString());

        // PUNTO 3
        System.out.println("PUNTO 3\n");
        requerimientos.companiaXComision();
    }
}

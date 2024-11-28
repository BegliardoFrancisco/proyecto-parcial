package utnfc.isi.backend.parcial.services.implementation;

import utnfc.isi.backend.parcial.Entities.Compania;
import utnfc.isi.backend.parcial.Entities.Empleado;
import utnfc.isi.backend.parcial.Repositories.implementations.EmpleadoRepositoryImpl;
import utnfc.isi.backend.parcial.services.interfaces.EmpleadoService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class EmpleadoServiceImpl extends ServiceImpl<Empleado,Integer> implements EmpleadoService {

    private CompaniaServiceImpl companiaService;

    public EmpleadoServiceImpl() {
        this.companiaService = new CompaniaServiceImpl();
        this.repository = new EmpleadoRepositoryImpl();
    }

    @Override
    public void bulkinsert(URL location) throws URISyntaxException, IOException {
        HashSet<Empleado> empleados = Files
                .lines(Paths.get(location.toURI()))
                .skip(1)
                .map(this::parseData)
                .collect(Collectors.toCollection(HashSet::new));

        empleados.forEach(System.out::println);

        empleados.forEach(empleado -> repository.add(empleado));
    }

    public Empleado parseData(String line) {

        String[] items = line.split("\\|");

        String identificacion = items[2];
        String nombre = items[4];
        String telefono = items[3];

        String companiaName = items[0];
        double comision = Double.parseDouble(items[1]);

        Compania compania = this.companiaService
                .findAll()
                .stream()
                .filter(c -> c.equals(new Compania(companiaName,comision)))
                .findFirst()
                .orElse(null);

        if (compania == null) {
            System.out.println("No se encuentra la compania del empleado");
        }

        return new Empleado(nombre,identificacion,telefono,compania);
    }


}

package utnfc.isi.backend.parcial.services.implementation;

import utnfc.isi.backend.parcial.Entities.OperadorTarjeta;
import utnfc.isi.backend.parcial.Repositories.implementations.OperadorTarjetaRepositoryImpl;
import utnfc.isi.backend.parcial.services.interfaces.OperadorTarjetaService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Collectors;

public class OperadorTarjetaServiceImpl extends ServiceImpl<OperadorTarjeta,Integer> implements OperadorTarjetaService {
    public OperadorTarjetaServiceImpl() {
        this.repository = new OperadorTarjetaRepositoryImpl();
    }


    @Override
    public void bulkinsert(URL location) throws URISyntaxException, IOException {

        HashSet<OperadorTarjeta> operadores = Files.lines(Paths.get(location.toURI()))
                .skip(1)
                .map(this::parseValue)
                .collect(Collectors.toCollection(HashSet::new));
        operadores.forEach(operador -> repository.add(operador));
    }

    public OperadorTarjeta parseValue(String line) {

        String[] items = line.split("\\|");

        String nombre = items[7];

        return new OperadorTarjeta(nombre);

    }


}

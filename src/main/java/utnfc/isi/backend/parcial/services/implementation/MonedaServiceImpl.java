package utnfc.isi.backend.parcial.services.implementation;

import utnfc.isi.backend.parcial.Entities.Compania;
import utnfc.isi.backend.parcial.Entities.Moneda;
import utnfc.isi.backend.parcial.Repositories.implementations.MonedaRepositoryImpl;
import utnfc.isi.backend.parcial.services.interfaces.MonedaService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Collectors;

public class MonedaServiceImpl extends ServiceImpl<Moneda,Integer> implements MonedaService{

    public MonedaServiceImpl() {
        repository = new MonedaRepositoryImpl();
    }


    @Override
    public void bulkinsert(URL location) throws URISyntaxException, IOException {
        HashSet<Moneda> monedas = Files.lines(Paths.get(location.toURI()))
                .skip(1)
                .map(this::parserValue)
                .collect(Collectors.toCollection(HashSet::new));

        monedas.forEach(moneda -> repository.add(moneda));
    }

    public Moneda parserValue(String line) {

        String[] items = line.split("\\|");

        String moneda = items[10];
        float cotizacion = Float.parseFloat(items[11]);

        return new Moneda(cotizacion,moneda);

    }


}

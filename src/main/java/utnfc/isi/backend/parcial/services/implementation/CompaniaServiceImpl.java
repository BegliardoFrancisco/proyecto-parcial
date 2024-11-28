package utnfc.isi.backend.parcial.services.implementation;

import utnfc.isi.backend.parcial.Entities.Compania;
import utnfc.isi.backend.parcial.Repositories.implementations.CompaniaRepositoryImpl;
import utnfc.isi.backend.parcial.services.interfaces.CompaniaService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CompaniaServiceImpl extends ServiceImpl<Compania,Integer> implements CompaniaService {


    public CompaniaServiceImpl() {
        repository = new CompaniaRepositoryImpl();
    }

    @Override
    public void bulkinsert(URL location) throws URISyntaxException, IOException {
        HashSet<Compania> companias = Files.lines(Paths.get(location.toURI()))
            .skip(1)
            .map(this::parserValue)
                .collect(Collectors.toCollection(HashSet::new));


        companias.forEach(compania -> repository.add(compania));
    }

    private Compania parserValue(String line) {
        String[] items = line.split("\\|");

        String nombre = items[0];
        double comision = Double.parseDouble(items[1]);

        return new Compania(nombre, comision);
    }


}

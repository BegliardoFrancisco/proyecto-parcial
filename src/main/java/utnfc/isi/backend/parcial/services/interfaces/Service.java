package utnfc.isi.backend.parcial.services.interfaces;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public interface Service<T,K> {

    void bulkinsert(URL location) throws URISyntaxException, IOException;
    List<T> findAll();
    Boolean countData();


}

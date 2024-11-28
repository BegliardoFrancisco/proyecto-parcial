package utnfc.isi.backend.parcial.Repositories.interfaces;

import java.util.List;

public interface Repository<T,K> {

    void add(T entitie);
    T delete(K id);
    void update(T entitie);
    T findById(K id);
    List<T> findAll();
    Long countData();

}

package utnfc.isi.backend.parcial.Repositories.implementations;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.Repositories.DbContext;
import utnfc.isi.backend.parcial.Repositories.interfaces.Repository;

public abstract class RepositoryImpl<T,K> implements Repository<T,K> {

    protected EntityManager context;

    public RepositoryImpl() {
        context = DbContext.getInstance().getEntityManager();
    }


}

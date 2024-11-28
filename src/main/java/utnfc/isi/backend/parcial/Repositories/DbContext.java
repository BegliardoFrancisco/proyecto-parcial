package utnfc.isi.backend.parcial.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbContext {

    private static DbContext instance;
    private EntityManager entityManager;

    private DbContext() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parcial-pu");
        entityManager = emf.createEntityManager();
    }

    public static DbContext getInstance() {
        if(instance == null) {
            instance = new DbContext();
        }
        return instance;
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }
}

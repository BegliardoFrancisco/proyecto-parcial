package utnfc.isi.backend.parcial.Repositories.implementations;

import utnfc.isi.backend.parcial.Entities.Compania;
import utnfc.isi.backend.parcial.Repositories.interfaces.CompaniaRepository;

import java.util.List;

public class CompaniaRepositoryImpl extends RepositoryImpl<Compania,Integer> implements CompaniaRepository {

    public CompaniaRepositoryImpl() {
        super();
    }

    @Override
    public void add(Compania entitie) {
        this.context.getTransaction().begin();
        this.context.persist(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public Compania delete(Integer id) {
        this.context.getTransaction().begin();
        Compania compania = this.findById(id);
        this.context.remove(compania);
        this.context.getTransaction().commit();
        return compania;
    }


    @Override
    public void update(Compania entitie) {
        this.context.getTransaction().begin();
        this.context.merge(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public Compania findById(Integer id) {
        return this.context.find(Compania.class, id);
    }

    @Override
    public List<Compania> findAll() {
        return this.context.createQuery("SELECT c FROM Compania c", Compania.class).getResultList();
    }

    @Override
    public Long countData() {
        this.context.getTransaction().begin();
        String query = "SELECT COUNT(c) FROM Compania c";
        Long result = this.context.createQuery(query, Long.class)
                .getSingleResult();
        System.out.println(result);
        this.context.getTransaction().commit();
        return result;
    }
}

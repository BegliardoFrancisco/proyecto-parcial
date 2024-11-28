package utnfc.isi.backend.parcial.Repositories.implementations;

import utnfc.isi.backend.parcial.Entities.Moneda;
import utnfc.isi.backend.parcial.Repositories.interfaces.MonedasRepository;

import java.util.List;

public class MonedaRepositoryImpl extends RepositoryImpl<Moneda,Integer> implements MonedasRepository {

    public MonedaRepositoryImpl() {
        super();
    }

    @Override
    public void add(Moneda entitie) {
        this.context.getTransaction().begin();
        this.context.persist(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public Moneda delete(Integer id) {
        this.context.getTransaction().begin();
        Moneda moneda = this.findById(id);
        this.context.remove(moneda);
        this.context.getTransaction().commit();
        return moneda;
    }

    @Override
    public void update(Moneda entitie) {
        this.context.getTransaction().begin();
        this.context.merge(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public Moneda findById(Integer id) {
        return this.context.find(Moneda.class, id);
    }

    @Override
    public List<Moneda> findAll() {
        return this.context.createQuery("SELECT m FROM Moneda m", Moneda.class).getResultList();
    }

    @Override
    public Long countData() {
        this.context.getTransaction().begin();
        String query = "SELECT COUNT(m) FROM Moneda m";
        Long result = this.context.createQuery(query, Long.class).getSingleResult();
        this.context.getTransaction().commit();
        return result;
    }
}

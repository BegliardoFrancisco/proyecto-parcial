package utnfc.isi.backend.parcial.Repositories.implementations;

import utnfc.isi.backend.parcial.Entities.OperadorTarjeta;
import utnfc.isi.backend.parcial.Repositories.interfaces.OperadorTarjetaRepository;

import java.util.List;

public class OperadorTarjetaRepositoryImpl extends RepositoryImpl<OperadorTarjeta,Integer> implements OperadorTarjetaRepository {


    public OperadorTarjetaRepositoryImpl() {
        super();
    }

    @Override
    public void add(OperadorTarjeta entitie) {
        this.context.getTransaction().begin();
        this.context.persist(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public OperadorTarjeta delete(Integer id) {
        this.context.getTransaction().begin();
        OperadorTarjeta operadorTarjeta = this.findById(id);
        this.context.remove(operadorTarjeta);
        this.context.getTransaction().commit();
        return operadorTarjeta;
    }

    @Override
    public void update(OperadorTarjeta entitie) {
        this.context.getTransaction().begin();
        this.context.merge(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public OperadorTarjeta findById(Integer id){
        return this.context.find(OperadorTarjeta.class, id);
    }

    @Override
    public List<OperadorTarjeta> findAll() {
        return this.context.createQuery("SELECT o FROM OperadorTarjeta o", OperadorTarjeta.class).getResultList();
    }
    @Override
    public Long countData() {
        this.context.getTransaction().begin();
        String query = "SELECT COUNT(o) FROM OperadorTarjeta o";
        Long result = this.context.createQuery(query, Long.class).getSingleResult();
        this.context.getTransaction().commit();
        return result;
    }
}

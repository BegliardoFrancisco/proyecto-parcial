package utnfc.isi.backend.parcial.Repositories.implementations;

import utnfc.isi.backend.parcial.Entities.Cuenta;
import utnfc.isi.backend.parcial.Repositories.interfaces.CuentaRepository;

import java.util.List;

public class CuentaRepositoryImpl extends RepositoryImpl<Cuenta,Integer> implements CuentaRepository {

    @Override
    public void add(Cuenta entitie) {
        this.context.getTransaction().begin();
        this.context.persist(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public Cuenta delete(Integer id) {
        this.context.getTransaction().begin();
        Cuenta cuenta = this.findById(id);
        this.context.remove(cuenta);
        this.context.getTransaction().commit();
        return cuenta;
    }

    @Override
    public void update(Cuenta entitie) {
        this.context.getTransaction().begin();
        this.context.merge(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public Cuenta findById(Integer id) {
        return this.context.find(Cuenta.class, id);
    }

    @Override
    public List<Cuenta> findAll() {
        return this.context.createQuery("SELECT c FROM Cuenta c", Cuenta.class).getResultList();
    }
    @Override
    public Long countData() {
        this.context.getTransaction().begin();
        String query = "SELECT COUNT(Cuenta) FROM Cuenta";
        Long result = this.context.createQuery(query, Long.class).getSingleResult();
        this.context.getTransaction().commit();
        return result;
    }
}

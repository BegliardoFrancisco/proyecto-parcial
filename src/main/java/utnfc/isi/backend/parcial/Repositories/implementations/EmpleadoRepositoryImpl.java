package utnfc.isi.backend.parcial.Repositories.implementations;

import utnfc.isi.backend.parcial.Entities.Empleado;
import utnfc.isi.backend.parcial.Repositories.interfaces.EmpleadoRepository;

import java.util.List;

public class EmpleadoRepositoryImpl extends RepositoryImpl<Empleado,Integer> implements EmpleadoRepository {

    public EmpleadoRepositoryImpl() {
        super();
    }

    @Override
    public void add(Empleado entitie) {
        this.context.getTransaction().begin();
        this.context.persist(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public Empleado delete(Integer id) {
        this.context.getTransaction().begin();
        Empleado empleado = this.findById(id);
        this.context.remove(empleado);
        this.context.getTransaction().commit();
        return empleado;
    }

    @Override
    public void update(Empleado entitie) {
        this.context.getTransaction().begin();
        this.context.merge(entitie);
        this.context.getTransaction().commit();
    }

    @Override
    public Empleado findById(Integer id) {
        return this.context.find(Empleado.class, id);
    }

    @Override
    public List<Empleado> findAll() {
        return this.context.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();

    }

    @Override
    public Long countData() {
        this.context.getTransaction().begin();
        String query = "SELECT COUNT(e) FROM Empleado e";
        Long result = this.context.createQuery(query, Long.class).getSingleResult();
        this.context.getTransaction().commit();
        return result;
    }
}

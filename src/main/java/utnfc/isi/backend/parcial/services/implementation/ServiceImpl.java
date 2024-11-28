package utnfc.isi.backend.parcial.services.implementation;

import utnfc.isi.backend.parcial.Entities.Compania;
import utnfc.isi.backend.parcial.Repositories.interfaces.Repository;
import utnfc.isi.backend.parcial.services.interfaces.Service;

import java.util.List;

public abstract class ServiceImpl<T,K> implements Service<T,K> {

    protected Repository<T,K> repository;

    @Override
    public Boolean countData() {
        return this.repository.countData() > 0;
    }

    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }
}

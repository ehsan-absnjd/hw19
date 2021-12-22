package ir.maktab.ticketsystem.repository.abstraction;

import ir.maktab.ticketsystem.entity.BaseEntity;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public interface RepositoryInterface<T extends BaseEntity<ID>, ID extends Number> {
    Optional<T> findById(ID id);
    public void saveOrUpdate(T entity);
    public List<T> findAll();
    public void delete(T entity);
}

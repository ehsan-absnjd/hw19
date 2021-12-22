package ir.maktab.ticketsystem.repository.abstraction;

import ir.maktab.ticketsystem.db.EntityManagerProvicer;
import ir.maktab.ticketsystem.entity.BaseEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<T extends BaseEntity<ID>,ID extends Number> implements RepositoryInterface<T  , ID> {
    protected Class<T> entityClass;
    protected EntityManager entityManager;

    public AbstractRepository() {
        entityManager = EntityManagerProvicer.getEntityManager();
        setEntityClass();
    }
    protected abstract void setEntityClass();

    public Optional<T> findById(ID id){
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    public void saveOrUpdate(T entity){
        startTransaction();
        if (entity.getId()==null){
            entityManager.persist(entity);
        }else {
            entityManager.merge(entity);
        }
        commitTransaction();
    }

    public List<T> findAll(){
        Query query = entityManager.createQuery("from " + entityClass.getSimpleName() + " e");
        return query.getResultList();
    }

    public void delete(T entity){
        startTransaction();
        entityManager.remove(entity);
        commitTransaction();
    }

    private void startTransaction(){
        entityManager.getTransaction().begin();
    }

    private void commitTransaction(){
        entityManager.getTransaction().commit();
    }
}

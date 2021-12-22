package ir.maktab.ticketsystem.repository;

import ir.maktab.ticketsystem.entity.User;
import ir.maktab.ticketsystem.repository.abstraction.AbstractRepository;
import ir.maktab.ticketsystem.repository.abstraction.UserRepositoryInterface;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User, Integer> implements UserRepositoryInterface {
    @Override
    protected void setEntityClass() {
        entityClass=User.class;
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> r = q.from(User.class);
        q.select(r).where(cb.equal(r.get("userName"),cb.parameter(String.class , "username") ));
        return Optional.ofNullable(entityManager.createQuery(q).setParameter("username", userName).getSingleResult());
    }
}

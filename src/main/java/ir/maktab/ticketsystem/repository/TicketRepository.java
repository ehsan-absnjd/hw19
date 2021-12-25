package ir.maktab.ticketsystem.repository;

import ir.maktab.ticketsystem.entity.Ticket;
import ir.maktab.ticketsystem.repository.abstraction.AbstractRepository;
import ir.maktab.ticketsystem.repository.abstraction.TicketRepositoryInterface;
import org.hibernate.boot.registry.classloading.internal.TcclLookupPrecedence;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepository extends AbstractRepository<Ticket , Integer> implements TicketRepositoryInterface {
    @Override
    protected void setEntityClass() {
        entityClass=Ticket.class;
    }

    @Override
    public List<Ticket> findTicketsByUserId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> q = cb.createQuery(Ticket.class);
        Root<Ticket> r = q.from(Ticket.class);
        ParameterExpression<Integer> idParameter = cb.parameter(Integer.class, "id");
        q.select(r).where(cb.equal(r.get("user").get("id") , idParameter ));
        return entityManager.createQuery(q).setParameter("id" , id).getResultList();
    }
}

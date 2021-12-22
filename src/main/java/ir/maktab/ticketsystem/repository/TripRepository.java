package ir.maktab.ticketsystem.repository;

import ir.maktab.ticketsystem.entity.Ticket;
import ir.maktab.ticketsystem.entity.Trip;
import ir.maktab.ticketsystem.repository.abstraction.AbstractRepository;
import ir.maktab.ticketsystem.repository.abstraction.TripRepositoryInterface;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class TripRepository extends AbstractRepository<Trip, Integer> implements TripRepositoryInterface {
    @Override
    protected void setEntityClass() {
        entityClass=Trip.class;
    }

    @Override
    public List<Trip> findTrips(String origin, String destination, LocalDate date) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Trip> q = cb.createQuery(Trip.class);
        Root<Trip> r = q.from(Trip.class);
        Predicate originPredicate = cb.equal(r.get("origin"), cb.parameter(String.class,"origin"));
        Predicate destinationPredicate = cb.equal(r.get("destination"), cb.parameter(String.class,"destination"));
        Predicate datePredicate = cb.equal(r.get("date"), cb.parameter(LocalDate.class, "date"));
        q.select(r).where(cb.and(cb.and(originPredicate, destinationPredicate), datePredicate));
        return entityManager.createQuery(q).setParameter("origin" , origin)
                .setParameter("destination" , destination)
                .setParameter("date" , date).getResultList();
    }
}

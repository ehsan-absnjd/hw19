package ir.maktab.ticketsystem.repository.abstraction;

import ir.maktab.ticketsystem.entity.BaseEntity;
import ir.maktab.ticketsystem.entity.Ticket;

import java.util.List;

public interface TicketRepositoryInterface extends RepositoryInterface<Ticket  , Integer> {
    List<Ticket> findTicketsByUserId(Integer id);
}

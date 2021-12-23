package ir.maktab.ticketsystem.usecase;

import ir.maktab.ticketsystem.entity.Ticket;
import ir.maktab.ticketsystem.entity.Trip;
import ir.maktab.ticketsystem.entity.User;
import ir.maktab.ticketsystem.repository.abstraction.RepositoryInterface;
import ir.maktab.ticketsystem.repository.abstraction.TicketRepositoryInterface;
import ir.maktab.ticketsystem.repository.abstraction.TripRepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.AddTicketRequest;
import ir.maktab.ticketsystem.util.Context;

import java.util.Optional;

public class AddTicketUseCase implements UseCase {
    TicketRepositoryInterface ticketrepository = Context.getTicketRepository();
    RepositoryInterface userRepository = Context.getUserRepository();
    TripRepositoryInterface tripRepository = Context.getTripRepository();
    Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        AddTicketRequest req = (AddTicketRequest) request;
        Optional<User> user = userRepository.findById(req.getUserId());
        Optional<Trip> trip = tripRepository.findById(req.getTripId());
        if (!user.isPresent() || !trip.isPresent()){} //to do something
        Ticket ticket = new Ticket();
        ticket.setFullName(req.getFullName());
        ticket.setGender(req.getGender());
        ticket.setUser(user.get());
        ticket.setTrip(trip.get());
        ticketrepository.saveOrUpdate(ticket);
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
}

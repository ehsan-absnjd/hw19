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

import java.util.HashMap;
import java.util.Optional;

public class AddTicketUseCase implements UseCase {
    TicketRepositoryInterface ticketrepository = Context.getTicketRepository();
    RepositoryInterface userRepository = Context.getUserRepository();
    TripRepositoryInterface tripRepository = Context.getTripRepository();
    Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        System.out.println("inside use case");
        AddTicketRequest req = (AddTicketRequest) request;
        System.out.println(req.getUserId());
        System.out.println(req.getFullName());
        System.out.println(req.getTripId());
        Optional<User> user = userRepository.findById(req.getUserId());
        Optional<Trip> trip = tripRepository.findById(req.getTripId());
        if (!user.isPresent() || !trip.isPresent()){} //to do something
        Ticket ticket = new Ticket();
        ticket.setFullName(req.getFullName());
        ticket.setGender(req.getGender());
        ticket.setUser(user.get());
        ticket.setTrip(trip.get());
        ticketrepository.saveOrUpdate(ticket);
        HashMap<String, Object> result = new HashMap<>();
        String message = ticket.isGender()? "mr. " : "mrs. ";
        message+= ticket.getFullName() + " your ticket with id: " + ticket.getId() +
                " for trip : " + ticket.getTrip().getId() + " has been puschased";
        result.put("message" , message);
        responder.render(result);
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
}

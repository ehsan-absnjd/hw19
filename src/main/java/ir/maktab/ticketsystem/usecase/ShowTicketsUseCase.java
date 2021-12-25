package ir.maktab.ticketsystem.usecase;

import ir.maktab.ticketsystem.entity.Ticket;
import ir.maktab.ticketsystem.repository.abstraction.TicketRepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.ShowTicketsRequest;
import ir.maktab.ticketsystem.util.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowTicketsUseCase implements UseCase {
    TicketRepositoryInterface repository = Context.getTicketRepository();
    private Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        ShowTicketsRequest req = (ShowTicketsRequest) request;
        Integer userId = req.getUserId();
        List<Ticket> ticketsByUserId = repository.findTicketsByUserId(userId);
        Map<String , Object> results = new HashMap<>();

        System.out.println(ticketsByUserId);
        results.put("tickets" , ticketsByUserId);
        responder.render(results);
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
}

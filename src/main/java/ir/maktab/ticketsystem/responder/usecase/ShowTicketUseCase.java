package ir.maktab.ticketsystem.responder.usecase;

import ir.maktab.ticketsystem.entity.Ticket;
import ir.maktab.ticketsystem.repository.abstraction.TicketRepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.responder.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.ShowTicketRequest;
import ir.maktab.ticketsystem.util.Context;

import java.util.Optional;

public class ShowTicketUseCase implements UseCase {
    TicketRepositoryInterface repository = Context.getTicketRepository();
    private Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        ShowTicketRequest req = (ShowTicketRequest) request;
        Integer ticketId = req.getTicketId();
        Integer userId = req.getUserId();
        Optional<Ticket> ticket = repository.findById(ticketId);
        if (!ticket.isPresent()){}
        if(ticket.get().getUser().getId()==userId){

        }
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
}

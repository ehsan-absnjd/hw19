package ir.maktab.ticketsystem.responder.usecase;

import ir.maktab.ticketsystem.repository.abstraction.TripRepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.responder.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.FindTripRequest;
import ir.maktab.ticketsystem.util.Context;

public class FindTripsUseCase implements UseCase {
    TripRepositoryInterface repository = Context.getTripRepository();
    private Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        FindTripRequest req = (FindTripRequest) request;
        repository.findTrips(req.getOrigin() , req.getDestinaion(),  req.getDate());
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
}

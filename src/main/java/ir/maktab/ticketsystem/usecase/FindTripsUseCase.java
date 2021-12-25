package ir.maktab.ticketsystem.usecase;

import ir.maktab.ticketsystem.entity.Trip;
import ir.maktab.ticketsystem.repository.abstraction.TripRepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.FindTripRequest;
import ir.maktab.ticketsystem.util.Context;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindTripsUseCase implements UseCase {
    TripRepositoryInterface repository = Context.getTripRepository();
    private Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        FindTripRequest req = (FindTripRequest) request;
        List<Trip> trips = repository.findTrips(req.getOrigin(), req.getDestinaion(), req.getDate());
        trips.stream().sorted(Comparator.comparing(Trip::getTime)).collect(Collectors.toList());
        Map<String , Object> results = new HashMap<>();
        results.put("trips" , trips);
        responder.render(results);
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
}

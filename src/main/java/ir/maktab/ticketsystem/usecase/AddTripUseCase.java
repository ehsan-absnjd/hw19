package ir.maktab.ticketsystem.usecase;

import ir.maktab.ticketsystem.entity.User;
import ir.maktab.ticketsystem.repository.abstraction.TripRepositoryInterface;
import ir.maktab.ticketsystem.repository.abstraction.UserRepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.AddTripRequest;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.util.Context;

import java.util.Optional;

public class AddTripUseCase implements UseCase {
    UserRepositoryInterface userRepository = Context.getUserRepository();
    TripRepositoryInterface tripRepository = Context.getTripRepository();
    private Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        AddTripRequest req = (AddTripRequest) request;
        Optional<User> user = userRepository.findByUserName(req.getUserName());
        if (!user.isPresent()||!user.isPresent()){

        }

    }

    @Override
    public void setResponder(Responder responder) {
        this.responder=responder;
    }
}

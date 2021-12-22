package ir.maktab.ticketsystem.responder.usecase;

import ir.maktab.ticketsystem.entity.User;
import ir.maktab.ticketsystem.repository.abstraction.UserRepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.responder.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.FindUserRequest;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.util.Context;

import java.util.Optional;

public class FindUserUseCase implements UseCase {
    UserRepositoryInterface userRepository = Context.getUserRepository();
    private Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        FindUserRequest req = (FindUserRequest) request;
        Optional<User> user = userRepository.findByUserName(req.getUserName());
        if(!user.isPresent()){
            System.out.println("notfound");
        }
        System.out.println(user.get().getUserName() );

    }

    @Override
    public void setResponder(Responder responder) {
        this.responder=responder;
    }
}

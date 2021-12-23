package ir.maktab.ticketsystem.usecase;

import ir.maktab.ticketsystem.entity.User;
import ir.maktab.ticketsystem.exception.UserNotFoundException;
import ir.maktab.ticketsystem.exception.WrongPasswordException;
import ir.maktab.ticketsystem.repository.abstraction.UserRepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.FindUserRequest;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.util.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FindUserUseCase implements UseCase {
    UserRepositoryInterface userRepository = Context.getUserRepository();
    private Responder responder;

    @Override
    public void process(UseCaseRequest request) {
        Map<String, Object> response = new HashMap<>();

        FindUserRequest req = (FindUserRequest) request;
        Optional<User> user = userRepository.findByUserName(req.getUserName());
        if(!user.isPresent()){
            response.put("error" , "user not found!");
            responder.render(response);
            return;
        }
        if (!user.get().getPassword().equals( req.getPassword())){
            response.put("error" , "password is wrong");
            responder.render(response);
            return;
        }
        response.put("user" , user.get());
        responder.render(response);
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder=responder;
    }
}

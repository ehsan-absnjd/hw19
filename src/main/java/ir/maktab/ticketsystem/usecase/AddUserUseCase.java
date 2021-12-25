package ir.maktab.ticketsystem.usecase;

import ir.maktab.ticketsystem.entity.User;
import ir.maktab.ticketsystem.repository.abstraction.RepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.AddUserRequest;
import ir.maktab.ticketsystem.util.Context;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AddUserUseCase implements UseCase {
    RepositoryInterface userRepository;
    private Responder responder;

    public AddUserUseCase() {
        userRepository = Context.getUserRepository();
    }

    @Override
    public void process(UseCaseRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            AddUserRequest req = (AddUserRequest) request;
            User user = new User();
            user.setUserName(req.getUserName());
            user.setPassword(req.getPassword());
            user.setAdmin(req.isAdmin());
            userRepository.saveOrUpdate(user);
            response.put("user" , user);
            responder.render(response);
        }catch (Exception e){
            response.put("error" , "somwthing went wrong");
            responder.render(response);
        }
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
}

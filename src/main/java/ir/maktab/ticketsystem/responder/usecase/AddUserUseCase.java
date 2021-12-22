package ir.maktab.ticketsystem.responder.usecase;

import ir.maktab.ticketsystem.entity.User;
import ir.maktab.ticketsystem.repository.abstraction.RepositoryInterface;
import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.responder.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.AddUserRequest;
import ir.maktab.ticketsystem.util.Context;

public class AddUserUseCase implements UseCase {
    RepositoryInterface userRepository;
    private Responder responder;

    public AddUserUseCase() {
        userRepository = Context.getUserRepository();
    }

    @Override
    public void process(UseCaseRequest request) {
        AddUserRequest req = (AddUserRequest) request;
        User user = new User();
        user.setUserName(req.getUserName());
        user.setPassword(req.getPassword());
        user.setAdmin(req.isAdmin());
        userRepository.saveOrUpdate(user);
    }

    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
}

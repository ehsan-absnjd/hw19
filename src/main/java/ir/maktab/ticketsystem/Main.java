package ir.maktab.ticketsystem;

import ir.maktab.ticketsystem.responder.usecase.abstraction.UseCase;
import ir.maktab.ticketsystem.responder.usecase.factory.UseCaseFactory;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;
import ir.maktab.ticketsystem.usecaserequest.factory.UseCaseRequestFactory;
import ir.maktab.ticketsystem.util.Context;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UseCaseFactory useCaseFactory = Context.getUseCaseFactory();
        UseCase addUserUseCase = useCaseFactory.create("FindUserUseCase");
        UseCaseRequestFactory requestFactory = Context.getUseCaseRequestFactory();
        UseCaseRequest request = requestFactory.create("FindUserRequest");
        Map<String,Object> params = new HashMap<>();
        params.put("username" , "ehsan");
        params.put("password" , "1234");
        //params.put("isadmin" , Boolean.TRUE);
        request.setParameters(params);
        addUserUseCase.process(request);
    }
}

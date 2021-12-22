package ir.maktab.ticketsystem.util;

import ir.maktab.ticketsystem.repository.TicketRepository;
import ir.maktab.ticketsystem.repository.TripRepository;
import ir.maktab.ticketsystem.repository.UserRepository;
import ir.maktab.ticketsystem.repository.abstraction.TicketRepositoryInterface;
import ir.maktab.ticketsystem.repository.abstraction.TripRepositoryInterface;
import ir.maktab.ticketsystem.repository.abstraction.UserRepositoryInterface;
import ir.maktab.ticketsystem.responder.usecase.*;
import ir.maktab.ticketsystem.usecase.*;
import ir.maktab.ticketsystem.responder.usecase.factory.UseCaseFactory;
import ir.maktab.ticketsystem.usecaserequest.*;
import ir.maktab.ticketsystem.usecaserequest.factory.UseCaseRequestFactory;

import java.util.HashSet;
import java.util.Set;

public class Context {
    private static Set<Class> useCaseClassSet = new HashSet<>();
    private static Set<Class> useCaseRequestClassSet=new HashSet<>();

    static {
        useCaseClassSet.add(AddUserUseCase.class);
        useCaseClassSet.add(AddTicketUseCase.class);
        useCaseClassSet.add(FindTripsUseCase.class);
        useCaseClassSet.add(RemoveTicketUseCase.class);
        useCaseClassSet.add(ShowTicketUseCase.class);
        useCaseClassSet.add(FindUserUseCase.class);

        useCaseRequestClassSet.add(AddUserRequest.class);
        useCaseRequestClassSet.add(AddTicketRequest.class);
        useCaseRequestClassSet.add(FindTripRequest.class);
        useCaseRequestClassSet.add(RemoveTicketRequest.class);
        useCaseRequestClassSet.add(ShowTicketRequest.class);
        useCaseRequestClassSet.add(FindUserRequest.class);
    }

    public static UserRepositoryInterface getUserRepository(){
        return new UserRepository();
    }

    public static TripRepositoryInterface getTripRepository(){
        return new TripRepository();
    }

    public static TicketRepositoryInterface getTicketRepository() {
        return new TicketRepository();
    }

    public static UseCaseFactory getUseCaseFactory(){
        UseCaseFactory factory = new UseCaseFactory(useCaseClassSet);
        return factory;
    }

    public static UseCaseRequestFactory getUseCaseRequestFactory(){
        UseCaseRequestFactory factory = new UseCaseRequestFactory(useCaseRequestClassSet);
        return factory;
    }
}

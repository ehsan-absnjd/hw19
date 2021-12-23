package ir.maktab.ticketsystem.usecase.abstraction;

import ir.maktab.ticketsystem.responder.Responder;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

public interface UseCase {
    public void process(UseCaseRequest request);
    public void setResponder(Responder responder);
}

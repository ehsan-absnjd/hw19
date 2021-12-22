package ir.maktab.ticketsystem.usecaserequest;

import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

import java.util.Map;

public class RemoveTicketRequest implements UseCaseRequest {
    private Integer userId;
    private Integer TicketId;

    public RemoveTicketRequest() {
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        setUserId((Integer) parameters.get("userid"));
        setTicketId((Integer) parameters.get("ticketid"));
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTicketId(Integer ticketId) {
        TicketId = ticketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getTicketId() {
        return TicketId;
    }
}

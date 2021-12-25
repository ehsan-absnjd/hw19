package ir.maktab.ticketsystem.usecaserequest;

import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

import java.util.Map;

public class ShowTicketsRequest implements UseCaseRequest {
    private Integer userId;

    public ShowTicketsRequest() {
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        setUserId((Integer) parameters.get("userid"));
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}

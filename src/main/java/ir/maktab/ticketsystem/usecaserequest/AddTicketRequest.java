package ir.maktab.ticketsystem.usecaserequest;

import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

import java.util.Map;

public class AddTicketRequest implements UseCaseRequest {
    private Integer userId;
    private Integer tripId;
    private String fullName;
    private Boolean gender;

    public AddTicketRequest() {
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        setUserId((Integer) parameters.get("userid"));
        setTripId((Integer) parameters.get("tripid"));
        setFullName((String) parameters.get("fullname"));
        setGender((Boolean) parameters.get("gender"));
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getTripId() {
        return tripId;
    }

    public String getFullName() {
        return fullName;
    }

    public Boolean getGender() {
        return gender;
    }
}

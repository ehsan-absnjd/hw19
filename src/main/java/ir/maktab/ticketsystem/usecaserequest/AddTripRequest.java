package ir.maktab.ticketsystem.usecaserequest;

import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class AddTripRequest implements UseCaseRequest {
    String userName;
    String origin;
    String destination;
    LocalDate date;
    LocalTime time;

    public AddTripRequest() {
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        setUserName((String) parameters.get("username"));
        setOrigin((String) parameters.get("origin"));
        setDestination((String) parameters.get("destination"));
        setDate((LocalDate) parameters.get("date"));
        setTime((LocalTime) parameters.get("time"));
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}

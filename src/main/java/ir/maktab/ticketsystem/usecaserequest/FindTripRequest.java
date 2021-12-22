package ir.maktab.ticketsystem.usecaserequest;

import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

import java.time.LocalDate;
import java.util.Map;

public class FindTripRequest implements UseCaseRequest {
    private String origin;
    private String destinaion;
    private LocalDate date;

    public FindTripRequest() {
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        setOrigin((String) parameters.get("origin"));
        setDestinaion((String) parameters.get("destination"));
        setDate((LocalDate) parameters.get("date"));
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestinaion(String destinaion) {
        this.destinaion = destinaion;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestinaion() {
        return destinaion;
    }

    public LocalDate getDate() {
        return date;
    }
}

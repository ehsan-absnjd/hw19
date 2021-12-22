package ir.maktab.ticketsystem.repository.abstraction;

import ir.maktab.ticketsystem.entity.Trip;

import java.time.LocalDate;
import java.util.List;

public interface TripRepositoryInterface extends RepositoryInterface<Trip, Integer >{
    List<Trip> findTrips(String origin, String destination, LocalDate date);
}

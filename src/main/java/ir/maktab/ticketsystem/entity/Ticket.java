package ir.maktab.ticketsystem.entity;

import javax.persistence.*;

@Entity
public class Ticket implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "trip_id")
    Trip trip;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    String fullName;

    boolean gender;

    public Ticket() {
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Trip getTrip() {
        return trip;
    }

    public User getUser() {
        return user;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isGender() {
        return gender;
    }
}

package ir.maktab.ticketsystem.repository.abstraction;

import ir.maktab.ticketsystem.entity.Trip;
import ir.maktab.ticketsystem.entity.User;

import java.util.Optional;

public interface UserRepositoryInterface extends RepositoryInterface<User, Integer >{
    Optional<User> findByUserName(String userName);
}

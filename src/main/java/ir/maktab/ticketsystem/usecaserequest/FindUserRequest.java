package ir.maktab.ticketsystem.usecaserequest;

import ir.maktab.ticketsystem.repository.abstraction.RepositoryInterface;
import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

import java.util.Map;

public class FindUserRequest implements UseCaseRequest {
    String userName;
    String password;

    public FindUserRequest() {
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        setUserName((String) parameters.get("username"));
        setPassword((String) parameters.get("password"));
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

package ir.maktab.ticketsystem.usecaserequest;

import ir.maktab.ticketsystem.usecaserequest.abstraction.UseCaseRequest;

import java.util.Map;

public class AddUserRequest implements UseCaseRequest {
    private String userName;
    private String password;
    private boolean isAdmin;

    public AddUserRequest() {
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        setUserName((String) parameters.get("username"));
        setPassword((String) parameters.get("password"));
        setAdmin((Boolean) parameters.get("isadmin"));
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}

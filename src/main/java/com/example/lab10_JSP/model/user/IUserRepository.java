package com.example.lab10_JSP.model.user;

public interface IUserRepository {
    boolean exists(String login, String password);
    void addNew(String login, String password);
}

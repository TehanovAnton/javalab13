package com.example.lab10_JSP.command.factory;


public enum CommandType {
    LOGIN("login"),
    SIGN_OUT("sign_out"),
    WELCOME("welcome"),
    REGISTER_NEW_USER("register_new_user"),
    ADD_NEW_CHANNEL("add_new_channel"),
    LOGIN_PAGE("login_page"),
    REGISTRATION_PAGE("registration_page");

    private String command;
    CommandType(String command) {
        this.command = command;
    }
}

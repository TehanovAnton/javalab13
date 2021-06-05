package com.example.lab10_JSP;

public enum Page {
    LOGIN_PAGE("/login"),
    REGISTER_PAGE("/register"),
    WElCOME_PAGE("/welcome"),
    ERROR_PAGE("/error");

    private final String value;

    Page(String value) {
        this.value = value;
    }

    public String getPage() {
        return value;
    }
}

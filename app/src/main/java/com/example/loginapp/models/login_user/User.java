package com.example.loginapp.models.login_user;

public class User {
    private String uiD;
    private String email;
    private String password;

    public User(String uiD, String email, String password) {
        this.uiD = uiD;
        this.email = email;
        this.password = password;
    }

    public String getUiD() {
        return uiD;
    }

    public void setUiD(String uiD) {
        this.uiD = uiD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

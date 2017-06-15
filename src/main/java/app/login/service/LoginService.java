package app.login.service;

public interface LoginService {
    boolean logIn(String username, String password);

    void logOut();
}

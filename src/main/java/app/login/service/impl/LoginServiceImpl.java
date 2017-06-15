package app.login.service.impl;

import app.auth.service.AuthenticationService;
import app.login.service.LoginService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LoginServiceImpl implements LoginService {

    private final AuthenticationService authenticationService;

    @Inject
    public LoginServiceImpl(final AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public boolean logIn(final String username, final String password) {
        final Authentication authentication = authenticationService.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication.isAuthenticated();
    }

    @Override
    public void logOut() {
        SecurityContextHolder.clearContext();
    }
}

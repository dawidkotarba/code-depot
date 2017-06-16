package app.registration.service;

import app.authentication.model.UserRole;

public interface RegistrationService {
    void registerUser(String username, String password, UserRole... authorities);
}

package app.registration.service;

import app.auth.model.UserRole;

public interface RegistrationService {
    void registerUser(String username, String password, UserRole... authorities);
}

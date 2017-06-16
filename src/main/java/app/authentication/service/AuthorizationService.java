package app.authentication.service;

import app.authentication.model.UserRole;

public interface AuthorizationService {
    void authorize(UserRole... authorizedRoles);
}

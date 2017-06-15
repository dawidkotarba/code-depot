package app.auth.service;

import app.auth.model.UserRole;

public interface AuthorizationService {
    void authorize(UserRole... authorizedRoles);
}

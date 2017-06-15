package app.auth.service;

import app.auth.model.UserRole;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface AuthenticationService {
    Authentication authenticate(String username, String password);

    Set<UserRole> getCurrentUserAuthorities();

    boolean hasCurrentUserAuthority(UserRole userRole);

    boolean isAdmin();
}

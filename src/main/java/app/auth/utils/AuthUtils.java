package app.auth.utils;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public final class AuthUtils {
    private AuthUtils() {
        // intentionally left blank
    }

    public static boolean isAuthorized(final Set<? extends GrantedAuthority> userRoles, final Set<? extends GrantedAuthority> allowedRoles) {
        for (GrantedAuthority allowedRole : allowedRoles) {
            if (userRoles.contains(allowedRole)) {
                return true;
            }
        }
        return false;
    }
}

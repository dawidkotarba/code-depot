package app.authentication.service.impl;

import app.authentication.model.UserRole;
import app.authentication.service.AuthorizationService;
import app.authentication.utils.AuthUtils;
import app.common.exceptions.model.NotAuthorizedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.inject.Named;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Named
public class AuthorizationServiceImpl implements AuthorizationService {

    @Override
    public void authorize(final UserRole... authorizedRoles) {
        final Set<UserRole> allowedRoles = new HashSet<>(Arrays.asList(authorizedRoles));
        final Set<? extends GrantedAuthority> userRoles =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().collect(Collectors.toSet());
        if (AuthUtils.isAuthorized(userRoles, allowedRoles)) {
            return;
        }
        throw new NotAuthorizedException("Unauthorized");
    }
}

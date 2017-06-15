package app.auth.service.impl;

import app.auth.model.UserRole;
import app.auth.service.AuthenticationService;
import com.google.common.base.Preconditions;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Named
public class AuthenticationServiceImpl implements AuthenticationService {

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    @Inject
    public AuthenticationServiceImpl(final DaoAuthenticationProvider daoAuthenticationProvider) {
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(final String username, final String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);

        return daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    @Override
    public Set<UserRole> getCurrentUserAuthorities() {
        final Collection<UserRole> authorities = (Collection<UserRole>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.stream().collect(Collectors.toSet());
    }

    @Override
    public boolean hasCurrentUserAuthority(final UserRole userRole) {
        final Set<UserRole> usersAuthorities = getCurrentUserAuthorities();
        return usersAuthorities.stream().anyMatch(role -> role.equals(userRole));
    }

    @Override
    public boolean isAdmin() {
        return hasCurrentUserAuthority(UserRole.ROLE_ADMIN);
    }
}

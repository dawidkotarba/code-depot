package app.registration.service.impl;

import app.auth.model.UserRole;
import app.common.model.User;
import app.common.repository.UserRepository;
import app.registration.service.RegistrationService;
import com.google.common.base.Preconditions;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.HashSet;

@Named
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Inject
    public RegistrationServiceImpl(final UserRepository userRepository, final BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(final String username, final String password, final UserRole... authorities) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);
        Preconditions.checkNotNull(authorities);

        final User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAuthorities(new HashSet<>(Arrays.asList(authorities)));
        userRepository.save(user);
    }
}


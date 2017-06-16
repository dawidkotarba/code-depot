package app.authentication.model;

import app.authentication.utils.AuthUtils;
import app.common.domain.BusinessObject;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.HashSet;

public class UserBo extends BusinessObject<UserDocument> {

    public UserBo(final UserDocument userDocument) {
        super(userDocument, UserDocument.class, "userRepository");
    }

    public void register(final String username, final String password, final UserRole... authorities) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);
        Preconditions.checkNotNull(authorities);

        getDocument().setUsername(username);
        getDocument().setPassword(AuthUtils.getPasswordEncoder().encode(password));
        getDocument().setEnabled(true);
        getDocument().setCredentialsNonExpired(true);
        getDocument().setAccountNonExpired(true);
        getDocument().setAccountNonLocked(true);
        getDocument().setAuthorities(new HashSet<>(Arrays.asList(authorities)));
        getRepository().save(getDocument());
    }
}


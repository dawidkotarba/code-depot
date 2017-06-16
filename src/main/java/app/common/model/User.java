package app.common.model;

import app.auth.model.UserRole;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Set;

@Data
public class User extends AbstractDocument implements UserDetails {

    @Indexed(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private Date creationDate;
    private Set<UserRole> authorities;
}

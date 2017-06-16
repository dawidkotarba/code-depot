package app.authentication.model;

import app.common.model.AbstractDocument;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Set;

@Data
public class UserDocument extends AbstractDocument implements UserDetails {

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

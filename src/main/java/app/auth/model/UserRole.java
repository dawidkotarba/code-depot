package app.auth.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_ANONYMOUS {
        @Override
        public String getAuthority() {
            return name();
        }
    }, ROLE_CUSTOMER {
        @Override
        public String getAuthority() {
            return name();
        }
    }, ROLE_SPECIALIST {
        @Override
        public String getAuthority() {
            return name();
        }
    }, ROLE_ADMIN {
        @Override
        public String getAuthority() {
            return name();
        }
    }
}

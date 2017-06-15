package app.auth.annotations;

import app.auth.model.UserRole;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface Authorize {
    UserRole[] userRole();
}

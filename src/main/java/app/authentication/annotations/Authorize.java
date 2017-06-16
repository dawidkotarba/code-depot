package app.authentication.annotations;

import app.authentication.model.UserRole;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface Authorize {
    UserRole[] userRole();
}

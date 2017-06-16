package app.authentication.aop;

import app.authentication.annotations.Authorize;
import app.authentication.service.AuthorizationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Method;

@Named
@Aspect
public class AuthorizationAspect {

    private final AuthorizationService authorizationService;

    @Inject
    public AuthorizationAspect(final AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Before("@annotation(app.authentication.annotations.Authorize)")
    public void checkAuthorization(final JoinPoint joinPoint) {

        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final Method method = signature.getMethod();
        final Authorize authorizeAnnotation = method.getAnnotation(Authorize.class);
        authorizationService.authorize(authorizeAnnotation.userRole());
    }
}

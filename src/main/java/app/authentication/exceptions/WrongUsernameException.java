package app.authentication.exceptions;

import app.common.exceptions.model.AbstractApplicationRuntimeException;

public class WrongUsernameException extends AbstractApplicationRuntimeException {
    public WrongUsernameException(final String message) {
        super(AuthenticationExceptionType.WRONG_USERNAME, message);
    }

    public WrongUsernameException(final Throwable cause) {
        super(AuthenticationExceptionType.WRONG_USERNAME, cause);
    }

    public WrongUsernameException(final String message, final Throwable cause) {
        super(AuthenticationExceptionType.WRONG_USERNAME, message, cause);
    }
}

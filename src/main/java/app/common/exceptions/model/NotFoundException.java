package app.common.exceptions.model;

public class NotFoundException extends AbstractApplicationRuntimeException {

    public NotFoundException(final String message) {
        super(CommonExceptionType.NOT_FOUND, message);
    }

    public NotFoundException(final Throwable cause) {
        super(CommonExceptionType.NOT_FOUND, cause);
    }

    public NotFoundException(final String message, final Throwable cause) {
        super(CommonExceptionType.NOT_FOUND, message, cause);
    }
}
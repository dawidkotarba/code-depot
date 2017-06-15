package app.common.exceptions.model;

public class InternalErrorException extends AbstractApplicationRuntimeException {

    public InternalErrorException(final String message) {
        super(CommonExceptionType.INTERNAL_ERROR, message);
    }

    public InternalErrorException(final Throwable cause) {
        super(CommonExceptionType.INTERNAL_ERROR, cause);
    }

    public InternalErrorException(final String message, final Throwable cause) {
        super(CommonExceptionType.INTERNAL_ERROR, message, cause);
    }
}
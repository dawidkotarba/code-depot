package app.common.exceptions.model;

import app.common.exceptions.service.ExceptionService;
import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class AbstractApplicationRuntimeException extends RuntimeException {

    private static ExceptionService exceptionService;
    private UUID uuid;
    private ExceptionType exceptionType;
    private String[] params;
    private String userMessage;
    private String devMessage;

    public AbstractApplicationRuntimeException(final ExceptionType exceptionType, final String message) {
        super(message);
        init(exceptionType);
    }

    public AbstractApplicationRuntimeException(final ExceptionType exceptionType, final Throwable cause) {
        super(cause);
        init(exceptionType);
    }

    public AbstractApplicationRuntimeException(final ExceptionType exceptionType, final String message, final Throwable cause) {
        super(message, cause);
        init(exceptionType);
    }

    private void init(final ExceptionType exceptionType) {
        uuid = UUID.randomUUID();
        this.exceptionType = exceptionType;
        exceptionService.localize(this);
    }

    public AbstractApplicationRuntimeException addParams(final String... params) {
        this.params = params;
        return this;
    }

    public void addMessages(final String userMessage, final String devMessage) {
        this.userMessage = userMessage;
        this.devMessage = devMessage;
    }

    public static void setExceptionService(final ExceptionService exceptionService) {
        AbstractApplicationRuntimeException.exceptionService = exceptionService;
    }
}
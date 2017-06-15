package app.common.exceptions.service;

import app.common.exceptions.model.AbstractApplicationRuntimeException;
import app.common.exceptions.model.ExceptionType;

public interface ExceptionService {
    void localize(AbstractApplicationRuntimeException e);

    String getLocalizedUserMessage(ExceptionType exceptionType, String[] params);
}

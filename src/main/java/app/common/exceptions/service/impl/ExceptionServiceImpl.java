package app.common.exceptions.service.impl;

import app.common.exceptions.model.AbstractApplicationRuntimeException;
import app.common.exceptions.model.ExceptionType;
import app.common.exceptions.service.ExceptionService;
import app.common.i18n.service.LocalizationService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ExceptionServiceImpl implements ExceptionService {

    private final LocalizationService localizationService;

    @Inject
    public ExceptionServiceImpl(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @PostConstruct
    public void init() {
        AbstractApplicationRuntimeException.setExceptionService(this);
    }


    @Override
    public void localize(final AbstractApplicationRuntimeException e) {
        final String userMessage = getLocalizedUserMessage(e.getExceptionType(), e.getParams());
        final String devMessage = e.getMessage();
        e.addMessages(userMessage, devMessage);
    }

    @Override
    public String getLocalizedUserMessage(ExceptionType exceptionType, String[] params) {
        return (params != null) ? localizationService.getMessage(exceptionType.name(), params) : localizationService.getMessage(exceptionType.name());
    }
}
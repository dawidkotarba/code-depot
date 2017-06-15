package app.common.view.service;

import app.common.exceptions.model.AbstractApplicationRuntimeException;
import com.vaadin.server.*;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Notification;


/**
 * Created on 02.04.2017.
 */
public class CustomErrorHandler implements ErrorHandler {
    @Override
    public void error(final ErrorEvent errorEvent) {
        final Throwable throwable = errorEvent.getThrowable();
        String userMessage = null;
        if (throwable instanceof AbstractApplicationRuntimeException) {
            userMessage = ((AbstractApplicationRuntimeException) throwable).getUserMessage();
            Notification.show(userMessage, Notification.Type.ERROR_MESSAGE);
        }

        final AbstractComponent component = DefaultErrorHandler.findAbstractComponent(errorEvent);
        if (component != null && userMessage != null) {
            ErrorMessage errorMessage = new UserError(userMessage);
            component.setComponentError(errorMessage);
            return;
        }
        DefaultErrorHandler.doDefault(errorEvent);
    }
}
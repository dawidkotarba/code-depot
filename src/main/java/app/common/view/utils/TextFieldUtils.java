package app.common.view.utils;

import app.common.i18n.service.impl.DefaultLocalizationService;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.server.UserError;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public final class TextFieldUtils {

    private TextFieldUtils() {
        // intentionally left blank
    }

    public static void addValidationNotEmpty(final TextField textField) {
        textField.setRequiredIndicatorVisible(true);
        textField.addBlurListener(blurEvent -> {
            if (textField.isEmpty()) {
                addErrorMessage(textField, "error.field.required");
            } else {
                textField.setComponentError(null);
            }
        });
    }

    public static void addValidationEmail(final TextField textField) {
        textField.addBlurListener(blurEvent -> {
            final EmailValidator emailValidator = new EmailValidator("error.field.email");
            final ValidationResult result = emailValidator.apply(textField.getValue(), null);
            if (result.isError()) {
                addErrorMessage(textField, "error.field.email");
            } else {
                textField.setComponentError(null);
            }
        });
    }

    private static void addErrorMessage(final TextField textField, final String errorStringCode) {
        final String errorStr = DefaultLocalizationService.getInstance().getMessage(errorStringCode, new String[]{textField.getCaption()});
        textField.setComponentError(new UserError(errorStr));
        Notification.show(errorStr, Notification.Type.TRAY_NOTIFICATION);
    }
}
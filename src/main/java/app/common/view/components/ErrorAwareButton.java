package app.common.view.components;

import app.common.i18n.service.impl.DefaultLocalizationService;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ErrorAwareButton extends Button {

    // true if has component error
    private Map<TextField, Boolean> registeredFields = new HashMap<>();

    public ErrorAwareButton(final String caption, final TextField... fieldsToCheckErrors) {
        super(caption);
        setErrorDescription();
        Arrays.asList(fieldsToCheckErrors).forEach(this::registerTextField);
        enableIfAllValid();
    }

    public void registerTextField(final TextField textField) {
        registeredFields.put(textField, true);
        textField.addBlurListener(blurEvent -> {
            markIfNoError(textField);
            enableIfAllValid();
        });
    }

    void markIfNoError(final TextField textField) {
        if (textField.getComponentError() == null) {
            registeredFields.put(textField, false);
        } else {
            registeredFields.put(textField, true);
        }
    }

    void enableIfAllValid() {
        final boolean haveErrors = registeredFields.values().stream().anyMatch(Boolean::booleanValue);
        if (haveErrors) {
            disable();
        } else {
            enable();

        }
    }

    void setErrorDescription() {
        final String description = DefaultLocalizationService.getInstance().getMessage("error.aware.button.description");
        setDescription(description);
    }

    void enable() {
        setEnabled(true);
        setDescription("");
    }

    void disable() {
        if (getDescription().isEmpty()) {
            setErrorDescription();
        }
        setEnabled(false);
    }
}

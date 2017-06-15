package app.common.view.components;

import app.common.view.utils.TextFieldUtils;
import com.vaadin.ui.PasswordField;

public class RequiredPasswordField extends PasswordField {

    public RequiredPasswordField(final String caption) {
        super(caption);
        TextFieldUtils.addValidationNotEmpty(this);
    }
}

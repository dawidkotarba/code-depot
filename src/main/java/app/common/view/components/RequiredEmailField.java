package app.common.view.components;

import app.common.view.utils.TextFieldUtils;
import com.vaadin.ui.TextField;

public class RequiredEmailField extends TextField {

    public RequiredEmailField(final String caption) {
        super(caption);
        TextFieldUtils.addValidationNotEmpty(this);
        TextFieldUtils.addValidationEmail(this);
    }
}

package app.common.view.components;

import app.common.view.utils.TextFieldUtils;
import com.vaadin.ui.TextField;

public class RequiredTextField extends TextField {

    public RequiredTextField(final String caption) {
        super(caption);
        TextFieldUtils.addValidationNotEmpty(this);
    }
}

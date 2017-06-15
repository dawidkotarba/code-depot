package app.common.view.components;

import app.common.i18n.service.impl.DefaultLocalizationService;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

/**
 * Created on 01.04.2017.
 */
public class InputLengthCounterLabel extends Label {

    public InputLengthCounterLabel(final TextField fieldToWatch) {
        super();
        updateLabel(fieldToWatch);
        attachToTextField(fieldToWatch);
    }

    void attachToTextField(final TextField fieldToWatch) {
        fieldToWatch.addValueChangeListener(e -> {
            updateLabel(fieldToWatch);
        });
        fieldToWatch.setValueChangeMode(ValueChangeMode.EAGER);
    }

    void updateLabel(final TextField fieldToWatch) {
        final int currentLength = fieldToWatch.getValue().length();
        final int maxLength = fieldToWatch.getMaxLength();
        final String separator = DefaultLocalizationService.getInstance().getMessage("input.counter.label.of");
        setValue(currentLength + " " + separator + " " + maxLength);
    }
}

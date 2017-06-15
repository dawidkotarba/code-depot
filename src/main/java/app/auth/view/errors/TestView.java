package app.auth.view.errors;

import app.auth.model.UserRole;
import app.auth.service.AuthorizationService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created on 30.03.2017.
 */
@Named
@UIScope
@Slf4j
public class TestView extends VerticalLayout implements View {

    private final AuthorizationService authorizationService;

    @Inject
    public TestView(final AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        authorizationService.authorize(UserRole.ROLE_ADMIN);
        final Label label = new Label("test label");
        addComponent(label);
        setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        Notification.show("Welcome to test page!");
    }
}
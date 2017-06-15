package app.auth.view;

import app.auth.model.UserRole;
import app.common.model.User;
import app.common.repository.UserRepository;
import app.common.view.components.*;
import app.login.service.LoginService;
import app.registration.service.RegistrationService;
import com.vaadin.data.Binder;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@UIScope
public class LoginView extends HorizontalLayout implements View {

    @Inject
    private UserRepository userRepository;

    @Inject
    private RegistrationService registrationService;

    @Inject
    private LoginService loginService;

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        if (userRepository.findAll().isEmpty()) {
            registrationService.registerUser("t@t.pl", "test", UserRole.ROLE_ADMIN);
            registrationService.registerUser("t2@t.pl", "test", UserRole.ROLE_CUSTOMER);
        }

        Panel panel = new Panel("test");
        panel.setSizeUndefined();
        addComponent(panel);
        FormLayout formLayout = new FormLayout();
        RequiredEmailField email = new RequiredEmailField("Email");
        email.setMaxLength(10);
        Binder<User> binder = new Binder<>();
//        binder.forField(email).withValidator(new EmailValidator("email!!!!")).
//                bind(User::getUsername, User::setUsername);
        formLayout.addComponent(email);

        RequiredPasswordField password = new RequiredPasswordField("Password");
        password.setRequiredIndicatorVisible(true);
        password.setMaxLength(10);
        binder.bind(password, User::getPassword, User::setPassword);
        formLayout.addComponent(password);

        final InputLengthCounterLabel counter = new InputLengthCounterLabel(password);
        formLayout.addComponent(counter);

        RequiredTextField company = new RequiredTextField("Company");
        company.setRequiredIndicatorVisible(true);

        formLayout.addComponent(company);
        formLayout.setSizeUndefined();
        formLayout.setMargin(true);

        Button button = new ErrorAwareButton("Log in", email, password);
        button.setEnabled(false);
        button.addClickListener(clickEvent -> {
            button.setCaption("logged");
            loginService.logIn(email.getValue(), password.getValue());
            System.out.println("Logged as " + email.getValue() + ", " + password.getValue());
        });
        formLayout.addComponent(button);

//        Button button2 = new Button("Log out");
//        button2.addClickListener(clickEvent -> {
//            button2.setCaption("logged out");
//            loginService.logOut();
//        });

        Button button2 = new Button("security");
        button2.addClickListener(clickEvent -> {
            final Navigator navigator = UI.getCurrent().getNavigator();
            navigator.navigateTo("test");
        });

        formLayout.addComponent(button2);

        panel.setContent(formLayout);
        setSizeFull();
        setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
    }
}

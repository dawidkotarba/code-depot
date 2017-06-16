package app.authentication.view;

import app.authentication.model.UserBo;
import app.authentication.model.UserDocument;
import app.authentication.model.UserRole;
import app.common.repository.UserRepository;
import app.common.view.components.*;
import app.login.service.LoginService;
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
    private LoginService loginService;

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        if (userRepository.findAll().isEmpty()) {
            final UserDocument userDocument = new UserDocument();
            final UserBo userBo = new UserBo(userDocument);
            userBo.register("test", "t@t.pl", UserRole.ROLE_ADMIN);
        }

        final Panel panel = new Panel("test");
        panel.setSizeUndefined();
        addComponent(panel);
        final FormLayout formLayout = new FormLayout();
        final RequiredEmailField email = new RequiredEmailField("Email");
        email.setMaxLength(10);
        final Binder<UserDocument> binder = new Binder<>();
//        binder.forField(email).withValidator(new EmailValidator("email!!!!")).
//                bind(User::getUsername, User::setUsername);
        formLayout.addComponent(email);

        final RequiredPasswordField password = new RequiredPasswordField("Password");
        password.setRequiredIndicatorVisible(true);
        password.setMaxLength(10);
        binder.bind(password, UserDocument::getPassword, UserDocument::setPassword);
        formLayout.addComponent(password);

        final InputLengthCounterLabel counter = new InputLengthCounterLabel(password);
        formLayout.addComponent(counter);

        final RequiredTextField company = new RequiredTextField("Company");
        company.setRequiredIndicatorVisible(true);

        formLayout.addComponent(company);
        formLayout.setSizeUndefined();
        formLayout.setMargin(true);

        final Button button = new ErrorAwareButton("Log in", email, password);
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

        final Button button2 = new Button("security");
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

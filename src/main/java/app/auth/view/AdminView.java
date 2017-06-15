package app.auth.view;

import app.login.service.LoginService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@SpringUI(path = "admin")
@Slf4j
public class AdminView extends UI {

    private final LoginService loginService;

    @Inject
    public AdminView(final LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    protected void init(final VaadinRequest vaadinRequest) {

//        if (!loginService.isAdmin()) {
//            final Label label = new Label("403");
//            setContent(label);
//            return;
//        }

        HorizontalLayout layout = new HorizontalLayout();
        Panel panel = new Panel("Admin view");
        layout.addComponent(panel);
        setContent(layout);
    }
}

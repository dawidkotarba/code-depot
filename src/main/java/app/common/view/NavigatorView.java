package app.common.view;

import app.common.view.service.CustomErrorHandler;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

import javax.inject.Inject;

@SpringUI
public class NavigatorView extends UI {

    Navigator navigator;

    @Inject
    private View loginView;

    @Inject
    private View testView;

    @Override
    protected void init(final VaadinRequest vaadinRequest) {
        final CustomErrorHandler errorHandler = new CustomErrorHandler();
        UI.getCurrent().setErrorHandler(errorHandler);
        VaadinSession.getCurrent().setErrorHandler(errorHandler);

        navigator = new Navigator(this, this);
        navigator.addView("", loginView);

        navigator.addView("test", testView);
    }
}

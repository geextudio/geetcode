package com.example.application.views.other;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("about")
public class AboutView extends VerticalLayout {
    public AboutView() {
        Label description = new Label("This is a demo of Vaadin + Springboot");
        add(
                new H1("About This App"),
                description
        );
    }
}

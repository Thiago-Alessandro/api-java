package net.weg.api.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Collection;

@Route(value = "/meus-seguros", layout = NavBarApp.class)
public class MeusSeguros extends VerticalLayout {

    public MeusSeguros(){
        Grid<Object> tabelaSeguros = new Grid(); //mudar identifier
        add(new H1("Meus Seguros"));
        add(tabelaSeguros);
    }

}

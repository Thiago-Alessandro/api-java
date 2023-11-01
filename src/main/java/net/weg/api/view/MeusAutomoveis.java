package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Carro;
import net.weg.api.service.CarroService;

@Route(value = "/meus-autos",layout = NavBarApp.class)
public class MeusAutomoveis extends VerticalLayout {

    public MeusAutomoveis(CarroService carroService){

        HorizontalLayout hl = new HorizontalLayout();
        hl.add(new H1("Meus Atumoveis"));
        Dialog cadastro = new Dialog();
        cadastro.add(new CadastroCarro(carroService, cadastro));

//        Button salvar = new Button("Salvar", e -> cadastro.close());

        hl.add(new Button("Novo Carro", e -> cadastro.open()) );
        add(hl);

        Grid tabelaAutomoveis = new Grid<>(Carro.class);
        tabelaAutomoveis.setItems(carroService.buscarTodos());
        add(tabelaAutomoveis);
    }

}

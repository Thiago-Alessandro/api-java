package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Collection;

public abstract class PaginaPadrao<T> extends VerticalLayout {

    private Grid<T> grid;
    private H1 titulo;
    private HorizontalLayout hl;

    PaginaPadrao(
            String titulo,
            Collection<T> itens,
            Class<T> classe
            ){
        this.grid = new Grid<>(classe);
        this.grid.setItems(itens);
        this.titulo = new H1(titulo);
        hl = new HorizontalLayout();
        hl.add(titulo);
        this.add(hl, grid);
    }

    PaginaPadrao(
            String titulo,
            Collection<T> itens,
            Class<T> classe,
            Button botao
    ){
        this(titulo, itens, classe);
        hl.add(botao);
    }


}

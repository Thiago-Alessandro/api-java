package net.weg.api.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Seguradora;
import net.weg.api.service.SeguradoraService;

@Route(value = "/seguradoras", layout = NavBarApp.class)
public class SeguradorasView extends PaginaPadrao<Seguradora> {

    private SeguradoraService seguradoraService;

    SeguradorasView(SeguradoraService seguradoraService){

        super("Seguradoras",
                seguradoraService.buscar(),
                Seguradora.class);
        this.seguradoraService = seguradoraService;

    }

}

package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Seguro;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

import java.util.ArrayList;
import java.util.Collection;

@Route(value = "/meus-seguros", layout = NavBarApp.class)
public class MeusSeguros extends PaginaPadrao {

    public MeusSeguros( SeguradoraService seguradoraService,
                        CarroService carroService,
                        ClienteService usuarioService,
                        SeguroService seguroService){

        super("Meus Seguros",
                seguroService.buscar(),
                Seguro.class,
                new Button("Novo Seguro", e -> {new CadastroSeguro(seguradoraService,carroService,usuarioService, seguroService).open();})
                );
    }

}

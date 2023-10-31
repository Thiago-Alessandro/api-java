package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;

import javax.swing.event.ChangeEvent;

public class CadastroCarro extends FormLayout {

    private final CarroService carroService;

    public CadastroCarro(CarroService carroService, Dialog dialog){

        this.carroService = carroService;

        TextField placa = new TextField("Placa");
        TextField marca = new TextField("Marca");
        TextField cor = new TextField("Cor");
        TextField modelo = new TextField("Modelo");
        IntegerField ano = new IntegerField("Ano");
        NumberField preco = new NumberField("Preço");

        Button salvar = new Button("Salvar", e -> {

                preco.getValue();
                CarroCadastroDTO carroCadastroDTO =
                        new CarroCadastroDTO(marca.getValue(),
                                placa.getValue(),
                                cor.getValue(),
                                modelo.getValue(),
                                preco.getValue(),
                                ano.getValue());

                try {
                    carroService.cadastrar(carroCadastroDTO);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                dialog.close();
        });

        Button cancelar = new Button("Cancelar", e -> dialog.close());

        dialog.getFooter().add(salvar, cancelar);

        add(placa,marca,cor,modelo,ano,preco, salvar, cancelar);

    }


}

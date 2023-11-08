package net.weg.api.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;


public class CadastroCarro extends Dialog {

    private final CarroService carroService;

    private TextField placa = new TextField("Placa");
    private TextField marca = new TextField("Marca");
    private TextField cor = new TextField("Cor");
    private TextField modelo = new TextField("Modelo");
    private IntegerField ano = new IntegerField("Ano");
    private NumberField preco = new NumberField("Preço");


    public CadastroCarro(CarroService carroService) throws Exception {

        this.carroService = carroService;

        FormLayout form = new FormLayout(placa, marca, cor, modelo, ano, preco);

        Button salvar = new BotaoSalvar (
                carroService,
                        new CarroCadastroDTO(marca.getValue(),
                                placa.getValue(),
                                cor.getValue(),
                                modelo.getValue(),
                                preco.getValue(),
                                ano.getValue()));

        Button cancelar = new Button("Cancelar", e -> this.close());

        this.getFooter().add(salvar, cancelar);

        add(form);

    }


}

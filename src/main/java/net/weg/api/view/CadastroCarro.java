package net.weg.api.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import lombok.Getter;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;


public class CadastroCarro extends IFormulario{

    private final CarroService carroService;

    private TextField placa = new TextField("Placa");
    private TextField marca = new TextField("Marca");
    private TextField cor = new TextField("Cor");
    private TextField modelo = new TextField("Modelo");
    private IntegerField ano = new IntegerField("Ano");
    private NumberField preco = new NumberField("Preço");

    @Getter
    private Button salvar;

    public CadastroCarro(CarroService carroService) {

        this.carroService = carroService;

        FormLayout form = new FormLayout(placa, marca, cor, modelo, ano, preco);

        this.salvar = criarBotaoSalvar();

//        this.cancelar = criarBotaoCancelar();
//
//        this.getFooter().add(salvar, cancelar);

        add(form);

    }

    private Button criarBotaoSalvar(){
        return new BotaoSalvar(e ->
        {
            com.vaadin.flow.component.notification.Notification notification = new Notification();
            notification.setDuration(3000);
            try {
                carroService.cadastrar(
                        new CarroCadastroDTO(marca.getValue(),
                                placa.getValue(),
                                cor.getValue(),
                                modelo.getValue(),
                                preco.getValue(),
                                ano.getValue()));
                notification.setText("Cadastro realizado com sucesso!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            } catch (Exception ex) {
                notification.setText("Erro ao cadastrar!");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            } finally {
                notification.open();
            }
        });
    }

//    private Button criarBotaoCancelar(){
//        return new BotaoCancelar(e -> this.close());
//    }

}

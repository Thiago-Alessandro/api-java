package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.Carro;
import net.weg.api.model.Cliente;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Usuario;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

import java.nio.channels.SelectableChannel;

@Data
@AllArgsConstructor
public class CadastroSeguro extends FormLayout {

    private SeguroService seguroService;

    CadastroSeguro(SeguradoraService seguradoraService,
                   CarroService carroService,
                   ClienteService usuarioService,
                   SeguroService seguroService,
                   Dialog dialog
                   ){

        this.seguroService = seguroService;

        NumberField valor = new NumberField("Valor");
        TextField descricao = new TextField("Descrição");
        NumberField valorFranquia = new NumberField("Valor Franquia");
        Select<Seguradora> seguradora = new Select<>();
        seguradora.setLabel("Seguradora");
        seguradora.setItems(seguradoraService.buscar());
        Select<Carro> veiculo = new Select<>();
        veiculo.setLabel("veiculo");
        veiculo.setItems(carroService.buscarTodos());
        Select<Cliente> usuario = new Select<>();
        usuario.setLabel("Ususario");
        usuario.setItems(usuarioService.buscarTodos());
        add(valor,valorFranquia,descricao,veiculo,seguradora,usuario);

        Button salvar = new Button("Salvar", e -> {

            SeguroCadastroDTO seguroCadastroDTO =
                    new SeguroCadastroDTO(valor.getValue(),
                            descricao.getValue(),
                            valorFranquia.getValue(),
                            seguradora.getValue(),
                            veiculo.getValue(),
                            usuario.getValue());

            try {
                seguroService.cadastrar(seguroCadastroDTO);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            dialog.close();
        });

        Button cancelar = new Button("Cancelar", e -> dialog.close());

        dialog.getFooter().add(salvar, cancelar);

    }

}

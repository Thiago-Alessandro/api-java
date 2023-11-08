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
public class CadastroSeguro extends Dialog {

    private SeguroService seguroService;

    private NumberField valor = new NumberField("Valor");
    private TextField descricao = new TextField("Descrição");
    private NumberField valorFranquia = new NumberField("Valor Franquia");

    private Select<Seguradora> seguradora = new Select<>();
    private Select<Carro> veiculo = new Select<>();
    private Select<Cliente> usuario = new Select<>();

    private Button salvar;
    private Button cancelar;

    private FormLayout formLayout = new FormLayout(valor, valorFranquia,descricao, veiculo, seguradora, usuario);

    CadastroSeguro(SeguradoraService seguradoraService,
                   CarroService carroService,
                   ClienteService usuarioService,
                   SeguroService seguroService
                   ){

        this.seguroService = seguroService;

        seguradora.setLabel("Seguradora");
        seguradora.setItems(seguradoraService.buscar());

        veiculo.setLabel("veiculo");
        veiculo.setItems(carroService.buscarTodos());

//        usuario.setItemLabelGenerator(Usuario::toString);
        usuario.setLabel("Ususario");
        usuario.setItems(usuarioService.buscarTodos());

        add(formLayout);

        salvar = new Button("Salvar", e -> {

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
            this.close();
        });

        cancelar = new Button("Cancelar", e -> this.close());

        this.getFooter().add(salvar, cancelar);

    }

}

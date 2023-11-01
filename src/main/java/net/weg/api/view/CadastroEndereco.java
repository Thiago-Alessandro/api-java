package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.Endereco;
import net.weg.api.model.dto.EnderecoCadastroDTO;


public class CadastroEndereco extends FormLayout {

    private TextField rua = new TextField("Rua"), bairro = new TextField("Bairro");
    private IntegerField numero = new IntegerField("Número");

    private Button salvar;
    private Button cancelar;

    CadastroEndereco(Grid<EnderecoCadastroDTO> enderecoGrid, Dialog dialog){

        salvar = new Button("Salvar", e -> {
//            enderecoGrid.getListDataView().addItem()
            enderecoGrid.getListDataView().addItem(
                    new EnderecoCadastroDTO(
                    rua.getValue(),
                    bairro.getValue(),
                    numero.getValue())
            );
                dialog.close();
        });

        cancelar = new Button("Cancelar", e -> dialog.close());
        dialog.getFooter().add(cancelar, salvar);
        add(rua,bairro,numero);

    }

}

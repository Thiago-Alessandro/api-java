package net.weg.api.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Modal extends Dialog {

    private IFormulario formulario;
    private Button cancelar;
    protected Modal(IFormulario formLayout){
        this.formulario = formLayout;
        cancelar = new BotaoCancelar(e -> this.close());
        this.getFooter().add(cancelar,formulario.getSalvar());
        this.add(formulario);
    }


}

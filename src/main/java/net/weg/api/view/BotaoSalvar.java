package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import net.weg.api.model.Endereco;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.service.IService;
import org.springframework.beans.BeanUtils;
import org.w3c.dom.events.Event;

import java.util.HashSet;
import java.util.Set;

public class BotaoSalvar<T, ID> extends Button {

    BotaoSalvar(ComponentEventListener<ClickEvent<Button>> event){
        super("Salvar",event);
    }

    BotaoSalvar(IService<T, ID> service, IDTO dto) {

        Notification notification = new Notification();
        notification.setDuration(3000);
        try {
            service.cadastrar(dto);
            notification.setText("Cadastro realizado com sucesso!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception exp) {
            notification.setText("Erro ao cadastrar!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } finally {
            notification.open();
        }
    }

    BotaoSalvar(Grid<T> grid, IDTO dto){
        Notification notification = new Notification();
        notification.setDuration(3000);
        try {
            grid.getListDataView().addItem((T) dto);
//            service.cadastrar(dto);
            notification.setText("Cadastro realizado com sucesso!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception exp) {
            notification.setText("Erro ao cadastrar!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } finally {
            notification.open();
        }
    }

}

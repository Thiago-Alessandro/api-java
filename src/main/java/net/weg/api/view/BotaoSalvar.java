package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import net.weg.api.model.Endereco;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.service.IService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

public class BotaoSalvar extends Button {

    BotaoSalvar(IService service, IDTO dto)throws Exception{

        Notification notification = new Notification();
        notification.setDuration(3000);
        try {
           service.cadastrar(dto);
            notification.setText("Cadasstro realizado com sucesso!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } catch (Exception exp) {
            notification.setText("Erro ao cadastrar!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } finally {
            notification.open();
        }

    }

}

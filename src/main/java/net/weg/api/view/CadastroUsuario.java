package net.weg.api.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.Endereco;
import net.weg.api.model.dto.EnderecoCadastroDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.service.ClienteService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@Route(value = "/cadastro-usuario", layout = NavBarApp.class)
public class CadastroUsuario extends VerticalLayout {

    private ClienteService usuarioService;

    private TextField nome = new TextField("Nome");
    private TextField sobrenome = new TextField("Sobrenome");
    private TextField usuario = new TextField("Usuario");
    private PasswordField senha = new PasswordField("Senha");
    private PasswordField confirmacaoSenha = new PasswordField("Confirmação Senha");
    private IntegerField idade = new IntegerField("Idade");
    private Grid<EnderecoCadastroDTO> tabelaEnderecos = new Grid<>(EnderecoCadastroDTO.class);
    private Dialog cadastroEndereco = new Dialog();

    private Button salvar;
    private Button cancelar;
    private Button novoEndereco;

    private FormLayout formLayout = new FormLayout();

    public CadastroUsuario(ClienteService service){

        this.setHorizontalComponentAlignment(Alignment.CENTER,formLayout);
        this.usuarioService = service;

        cadastroEndereco.add(new CadastroEndereco(tabelaEnderecos, cadastroEndereco));
        novoEndereco = new Button("Novo Endereço", e -> cadastroEndereco.open());

            salvar= new Button("Salvar", e -> {

                Notification notification = new Notification();
                notification.setDuration(3000);
                try {
                    if(!senha.getValue().equals(confirmacaoSenha.getValue())) {
                        throw new RuntimeException();
                    }
                    Set<Endereco> enderecos = new HashSet<>();
                    tabelaEnderecos.getListDataView().getItems().forEach(
                            ecdto -> {
                                Endereco endereco = new Endereco();
                                BeanUtils.copyProperties(ecdto,endereco);
                                enderecos.add(endereco);
                            }
                    );
                    usuarioService.cadastrar( //cadastrar/editar?
                        new UsuarioCadastroDTO(
                                nome.getValue(),
                                sobrenome.getValue(),
                                usuario.getValue(),
                                senha.getValue(),
                                idade.getValue(),
                                enderecos));

                    notification.setText("Usuário cadastrado com sucesso!");
                    notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                } catch (Exception exp) {
                    notification.setText("Erro no cadastro do usuário!");
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                } finally {
                    notification.open();
                }
            });
        salvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        cancelar = new Button("Cancelar", e -> new UI().navigate("/"));

        formLayout.setColspan(novoEndereco,2);
        formLayout.setColspan(tabelaEnderecos,2);
        formLayout.setMaxWidth("1000px");
        formLayout.add(nome, sobrenome, idade, usuario, senha, confirmacaoSenha, novoEndereco, tabelaEnderecos, cancelar, salvar);

        add(formLayout);

    }


}

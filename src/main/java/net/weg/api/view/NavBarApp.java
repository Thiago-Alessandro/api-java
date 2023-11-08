package net.weg.api.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class NavBarApp extends AppLayout {

    public NavBarApp() {
        H1 title = new H1("Seguraí");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("left", "var(--lumo-space-l)").set("margin", "0")
                .set("position", "absolute");

        Tabs tabs = getTabs();

        Button cadastro = new Button("Cadastrte-se", e -> {
            UI.getCurrent().navigate("cadastro-usuario");
        });

        cadastro.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cadastro.getStyle().set("margin","0 5% 0 0");

        addToNavbar(title, tabs, cadastro);
    }
    // end::snippet[]

    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.getStyle().set("margin", "auto");
        tabs.add(
                createTab("Cadastrar Usuario", CadastroUsuario.class),
                createTab("Início"),
                createTab("Meus Seguros", MeusSeguros.class),
                createTab("Meus Automóveis", MeusAutomoveis.class),
                createTab("Seguradoras", SeguradorasView.class),
                createTab("Perfil"));
        return tabs;
    }

    private Tab createTab(String viewName) {
        RouterLink link = new RouterLink();
        link.add(viewName);
        link.setTabIndex(-1);

        return new Tab(link);
    }


    private Tab createTab(String viewName, Class classe) {
        RouterLink link = new RouterLink();
        link.add(viewName);
        link.setRoute(classe);
        link.setTabIndex(-1);

        return new Tab(link);
    }

    // tag::snippet[]
}
// end::snippet[]

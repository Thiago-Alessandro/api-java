package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.Cliente;
import net.weg.api.model.Endereco;

import java.util.Collection;

@AllArgsConstructor
@Data
public class SeguradoraCadastroDTO implements IDTO{

    private Long cnpj;
    private String nome;
    private Endereco endereco;
    private Collection<Cliente> clientes;

}

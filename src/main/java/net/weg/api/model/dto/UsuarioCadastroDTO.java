package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.Endereco;

import java.util.Set;

@Data
@AllArgsConstructor
public class UsuarioCadastroDTO implements IDTO {

    private String nome;
    private String sobrenome;
    private String usuario;
    private String senha;
    private Integer idade;
    private Set<Endereco> endereco;

}

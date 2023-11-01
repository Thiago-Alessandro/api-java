package net.weg.api.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.model.Cliente;
import net.weg.api.model.Seguradora;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguroCadastroDTO {

    private Double valor;
//    private String nome;
    private String descricao;
    private Double valorFranquia;
    private Seguradora seguradora;
    private Carro veiculo;
    private Cliente cliente;


}

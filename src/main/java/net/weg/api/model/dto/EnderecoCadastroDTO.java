package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class EnderecoCadastroDTO {

    private String rua;
    private String bairro;
    private Integer numero;

}

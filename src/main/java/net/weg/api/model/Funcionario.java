package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_funcionario")
public class Funcionario extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Double salario;
    private Integer matricula;
    private String cargo;


}

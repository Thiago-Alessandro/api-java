package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
    @OneToOne (mappedBy = "veiculo")
    //(acima) entra na classe seguro e busca o atributo especificado para fazer a relacao com esta tabela
    private Seguro seguro;

    @Override
    public String toString(){
        return marca + " - " + modelo + " (" + placa + ") ";
    }

}

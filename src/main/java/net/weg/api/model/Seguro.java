package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_plano")
@IdClass(SeguroIdClass.class)
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroId;
    @Id
    private Integer seguradoraId;

    private Double valor;
    private String nome;
    private String descricao;
    private Double valorFranquia;

    @ManyToOne
    @JoinColumn(name = "seguradoraId")
    private Seguradora seguradora;
    @OneToOne
//    @MapsId("veiculoId")
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

}

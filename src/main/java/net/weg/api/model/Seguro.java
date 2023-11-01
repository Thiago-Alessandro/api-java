package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "tb_seguro")

@IdClass(SeguroIdClass.class)
public class Seguro {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

//    @EmbeddedId
//    private SeguroId id;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer seguroId;
    @Id
    private Integer seguradoraId;

    private Double valor;
    private String nome;
    private String descricao;
    private Double valorFranquia;

    @ManyToOne
    @JoinColumn(name = "seguradoraId")
//    @MapsId("seguradoraId")
    private Seguradora seguradora;
//    @MapsId("veiculoId")
    @OneToOne
//    @MapsId("veiculoId")
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

//  embeddedId usa mapsId() e Idclass(ClassName.class) usa JoinColumn()

}

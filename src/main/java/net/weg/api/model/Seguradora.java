package net.weg.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tb_seguradora")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seguradora {

    @Id
    @GeneratedValue(strategy =  GenerationType.TABLE)
    private Integer id;
    private Long cnpj;
    private String nome;
    @OneToOne
    private Endereco endereco;
    @ManyToMany(fetch = FetchType.EAGER)
    //@JsonIgnore
    private Set<Cliente> clientes;
}

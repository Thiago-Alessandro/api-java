package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString(callSuper = true)
@Entity
@Table(name = "tb_cliente")
public class Cliente extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Carro> carro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    //identifica que a outra classe ja tem o relacionamento e cria apenas um id para a relacao, senao criaria 2 id's (mappedBy sempre na relacao "OneToMany")
    private Set<Seguro> seguros;

    @Override
    public String toString(){
        return super.toString();
    }

}

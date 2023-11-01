package net.weg.api.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SeguroId {

    //    @EmbeddedId

    private Integer seguradoraId;
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer seguroId;

//    private Integer veiculoId;

}


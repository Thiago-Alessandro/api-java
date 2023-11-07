package net.weg.api.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
public class SeguroId implements Serializable {

    //    @EmbeddedId

    private Integer seguradoraId;
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer seguroId;
    private static Integer nextId = 1;

    protected SeguroId(){
        seguroId = nextId;
        nextId++;
    }

//    private Integer veiculoId;


}


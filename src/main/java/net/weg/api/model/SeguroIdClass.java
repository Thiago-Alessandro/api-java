package net.weg.api.model;

import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguroIdClass {

    private Integer seguradoraId;
    private Integer seguroId;

}
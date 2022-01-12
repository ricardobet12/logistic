package com.logistic.dto;

import com.logistic.entity.Envio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TerrestreDto {
    private Long idLogisticaTerrestre;
    private Integer puertoEntrega;
    private Integer numeroFlota;
    private String tipoProducto;
    private Integer cantidadProducto;
    private Envio fkEnvio;

}

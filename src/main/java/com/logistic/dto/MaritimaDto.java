package com.logistic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaritimaDto {

    private Long idLogisticaMaritima;
    private String bodegaEntrega;
    private String placaVehiculo;
    private EnvioDto fkEnvio;
    private String tipoProducto;
    private Integer cantidadProducto;
}

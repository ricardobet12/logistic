package com.logistic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnvioDto {

    private Long idEnvio;
    private Date fechaRegistro;
    private Date fechaEntrada;
    private Double precioEnvio;
    private Double descuento;
    private ClientesDto fkCliente;
    private Integer numeroGuia;
    private Integer bodega;
}

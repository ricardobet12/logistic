package com.logistic.service;

import com.logistic.dto.EnvioDto;
import com.logistic.dto.TerrestreDto;

import java.util.List;

public interface EnvioService {


    EnvioDto guardarEnvio(EnvioDto envio);


    EnvioDto obtenerEnvio(Long idEnvio);

    List<EnvioDto> obtenerTodos();
}

package com.logistic.service;

import com.logistic.dto.MaritimaDto;
import com.logistic.dto.TerrestreDto;

import java.util.List;

public interface TerrestreService {

    /**
     * Guarda una logistica terrestre
     * @param terrestre -> Logistica terrestre a guardar
     * @return objeto con la logistica terrestre guardada
     */
    TerrestreDto guardarTerrestre (TerrestreDto terrestre);

    /**
     * Retorna un terrestre de acuerdo a un id
     * @param idTerrestre -> Id de la maritima
     * @return objeto con el cliente consultar
     */
    TerrestreDto obtenerTerrestre(Long idTerrestre);

    /**
     * Retorna todos las terrestre
     * @return lista de las terrestre.
     */
    List<TerrestreDto> obtenerTodos();

    boolean eliminar(Long id);
}

package com.logistic.service;

import com.logistic.dto.MaritimaDto;

import java.util.List;

public interface MaritimaService {

    /**
     * Guarda una logistica maritima
     * @param maritima -> Logistica a guardar
     * @return objeto con la logistica guardada
     */
    MaritimaDto guardarMaritima (MaritimaDto maritima);

    /**
     * Retorna un cliente de acuerdo a un id
     * @param idMaritima -> Id de la maritima
     * @return objeto con la logistica maritina a consultar
     */
    MaritimaDto obtenerMaritima (Long idMaritima);

    /**
     * Retorna todos las maritimas
     * @return lista de las maritimas.
     */
    List<MaritimaDto> obtenerTodos();
}

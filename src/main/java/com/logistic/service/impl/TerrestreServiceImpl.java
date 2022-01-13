package com.logistic.service.impl;

import com.logistic.dto.TerrestreDto;
import com.logistic.entity.Terrestre;
import com.logistic.exceptions.responses.BadRequestException;
import com.logistic.repository.TerrestreRepository;
import com.logistic.service.TerrestreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TerrestreServiceImpl implements TerrestreService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private TerrestreRepository repository;


    @Override
    public TerrestreDto guardarTerrestre(TerrestreDto terrestre) {
        TerrestreDto sh = mapper.map(repository.save(mapper.map(terrestre, Terrestre.class)),TerrestreDto.class);
        return sh;
    }

    @Override
    public TerrestreDto obtenerTerrestre(Long idTerrestre) {
        Optional<Terrestre> terrestreOptional = repository.findById(idTerrestre);
        if (terrestreOptional.isPresent()) {
            return mapper.map(terrestreOptional.get(), TerrestreDto.class);
        }
        throw new BadRequestException("Ocurrio un error al obtener una logistica terrestre");
    }

    @Override
    public List<TerrestreDto> obtenerTodos() {
        List<TerrestreDto> respuesta = new ArrayList<>();
        List<Terrestre> terrestres = repository.findAll();
        if (terrestres != null) {
            for (Terrestre c : terrestres) {
                respuesta.add(mapper.map(c, TerrestreDto.class));
            }
            return respuesta;
        }
        throw new BadRequestException("Ocurrio un error de listar los clientes");
    }
}

package com.logistic.service.impl;

import com.logistic.dto.EnvioDto;
import com.logistic.dto.TerrestreDto;
import com.logistic.entity.Envio;
import com.logistic.entity.Terrestre;
import com.logistic.exceptions.responses.BadRequestException;
import com.logistic.repository.EnvioRepository;
import com.logistic.service.EnvioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioServiceImpl implements EnvioService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private EnvioRepository repository;


    @Override
    public EnvioDto guardarEnvio(EnvioDto envio) {
        EnvioDto sh = mapper.map(repository.save(mapper.map(envio, Envio.class)),EnvioDto.class);
        return sh;
    }

    @Override
    public EnvioDto obtenerEnvio(Long idEnvio) {
        Optional<Envio> envioOptional = repository.findById(idEnvio);
        if (envioOptional.isPresent()) {
            return mapper.map(envioOptional.get(), EnvioDto.class);
        }
        throw new BadRequestException("Ocurrio un error al obtener un envio");
    }

    @Override
    public List<EnvioDto> obtenerTodos() {
        List<EnvioDto> respuesta = new ArrayList<>();
        List<Envio> envios = repository.findAll();
        if (envios != null) {
            for (Envio c : envios) {
                respuesta.add(mapper.map(c, EnvioDto.class));
            }
            return respuesta;
        }
        throw new BadRequestException("Ocurrio un error de listar los envios");
    }
}

package com.logistic.service.impl;

import com.logistic.dto.MaritimaDto;
import com.logistic.entity.Maritima;
import com.logistic.exceptions.responses.BadRequestException;
import com.logistic.repository.MaritimaRepository;
import com.logistic.service.MaritimaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaritimaServiceImpl implements MaritimaService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private MaritimaRepository repository;

    @Override
    public MaritimaDto guardarMaritima(MaritimaDto maritima) {
        MaritimaDto sh = mapper.map(repository.save(mapper.map(maritima, Maritima.class)),MaritimaDto.class);
        return sh;
    }

    @Override
    public MaritimaDto obtenerMaritima(Long idMaritima) {
        Optional<Maritima> maritimaOptional = repository.findById(idMaritima);
        if (maritimaOptional.isPresent()) {
            return mapper.map(maritimaOptional.get(), MaritimaDto.class);
        }
        throw new BadRequestException("Ocurrio un error al obtener una logistica maritima");
    }

    @Override
    public List<MaritimaDto> obtenerTodos() {
        List<MaritimaDto> respuesta = new ArrayList<>();
        List<Maritima> maritimas = repository.findAll();
        if (maritimas != null) {
            for (Maritima c : maritimas) {
                respuesta.add(mapper.map(c, MaritimaDto.class));
            }
            return respuesta;
        }
        throw new BadRequestException("Ocurrio un error de listar los clientes");
    }
}

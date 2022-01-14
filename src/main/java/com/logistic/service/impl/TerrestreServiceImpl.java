package com.logistic.service.impl;

import com.logistic.dto.MaritimaDto;
import com.logistic.dto.TerrestreDto;
import com.logistic.entity.Clientes;
import com.logistic.entity.Envio;
import com.logistic.entity.Terrestre;
import com.logistic.exceptions.responses.BadRequestException;
import com.logistic.repository.EnvioRepository;
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

    @Autowired
    private EnvioRepository envioRepository;


    @Override
    public TerrestreDto guardarTerrestre(TerrestreDto terrestre) {
        if (terrestre.getFkEnvio() != null){
            this.aplicarDescuento(terrestre);
        }
        TerrestreDto sh = mapper.map(repository.save(mapper.map(terrestre, Terrestre.class)),TerrestreDto.class);
        return sh;
    }

    private void aplicarDescuento(TerrestreDto terrestre){
        if (terrestre.getCantidadProducto() > 10 && terrestre.getFkEnvio().getDescuento() == null){
            Double res = terrestre.getFkEnvio().getPrecioEnvio()*0.03;
            terrestre.getFkEnvio().setPrecioEnvio(terrestre.getFkEnvio().getPrecioEnvio()-res);
            terrestre.getFkEnvio().setDescuento(res);
            envioRepository.save(mapper.map(terrestre.getFkEnvio(), Envio.class));
        }
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

    @Override
    public boolean eliminar(Long id) {
        if (id != null) {
            Optional<Terrestre> u = repository.findById(id);
            if (u.isPresent()) {
                repository.delete(u.get());
                return true;
            }
        }
        return false;
    }
}

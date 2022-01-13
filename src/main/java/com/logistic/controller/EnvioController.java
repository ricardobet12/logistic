package com.logistic.controller;

import com.logistic.dto.EnvioDto;
import com.logistic.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envio")
@CrossOrigin(origins = "*")
public class EnvioController {

    @Autowired
    private EnvioService service;

    /**
     * metodo para listar todos los envios de la base de datos.
     *
     * @return lista de envios guardados en la base de datos
     */
    @GetMapping("/")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    /**
     * Servicio para obtener a un envio por su id.
     * @param id id del envio
     * @return objeto con la información del envio
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEnvio(@PathVariable("id") Long id) {
        EnvioDto envio = service.obtenerEnvio(id);
        if (envio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(envio);
    }

    /**
     * Metodo para insertar un envio en la base de datos.
     * @param envio datos del envio
     * @return objeto con los datos del envio ya almacenados
     */
    @PostMapping
    public ResponseEntity<?> insertarEnvio(@RequestBody EnvioDto envio) {
        envio = service.guardarEnvio(envio);
        if (envio == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(envio);
    }
}


package com.logistic.controller;

import com.logistic.dto.MaritimaDto;
import com.logistic.service.MaritimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v.1/maritima")
public class MaritimaController {

    @Autowired
    private MaritimaService service;

    /**
     * metodo para listar todos los usuario de la base de datos.
     *
     * @return lista de usuarios guardados en la base de datos
     */
    @GetMapping("/")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    /**
     * Servicio para obtener a un cliente por su id.
     * @param id id del cliente
     * @return objeto con la información del cliente
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMaritima(@PathVariable("id") Long id) {
        MaritimaDto maritima = service.obtenerMaritima(id);
        if (maritima == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maritima);
    }

    /**
     * Metodo para insertar un cliente en la base de datos.
     * @param maritima datos del cliente
     * @return objeto con los datos del clientes ya almacenados
     */
    @PostMapping
    public ResponseEntity<?> insertarMaritima(@RequestBody MaritimaDto maritima) {
        maritima = service.guardarMaritima(maritima);
        if (maritima == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(maritima);
    }
}

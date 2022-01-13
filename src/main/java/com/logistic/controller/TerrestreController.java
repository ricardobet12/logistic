package com.logistic.controller;

import com.logistic.dto.TerrestreDto;
import com.logistic.service.TerrestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/terrestre")
@CrossOrigin(origins = "*")
public class TerrestreController {

    @Autowired
    private TerrestreService service;

    /**
     * metodo para listar todos los terrestres de la base de datos.
     *
     * @return lista de terrestres guardados en la base de datos
     */
    @GetMapping("/")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    /**
     * Servicio para obtener a un terrestres por su id.
     * @param id id del terrestres
     * @return objeto con la información del terrestres
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTerrestre(@PathVariable("id") Long id) {
        TerrestreDto terrestre = service.obtenerTerrestre(id);
        if (terrestre == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(terrestre);
    }

    /**
     * Metodo para insertar un terrestres en la base de datos.
     * @param terrestre datos del terrestres
     * @return objeto con los datos del clientes ya terrestres
     */
    @PostMapping
    public ResponseEntity<?> insertarTerrestre(@RequestBody TerrestreDto terrestre) {
        terrestre = service.guardarTerrestre(terrestre);
        if (terrestre == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(terrestre);
    }
}

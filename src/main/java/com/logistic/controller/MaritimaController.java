package com.logistic.controller;

import com.logistic.dto.MaritimaDto;
import com.logistic.service.MaritimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maritima")
@CrossOrigin(origins = "*")
public class MaritimaController {

    @Autowired
    private MaritimaService service;

    /**
     * metodo para listar todos los maritima de la base de datos.
     *
     * @return lista de maritima guardados en la base de datos
     */
    @GetMapping("/")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    /**
     * Servicio para obtener a un maritima por su id.
     * @param id id del maritima
     * @return objeto con la información del maritima
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
     * Metodo para insertar un maritima en la base de datos.
     * @param maritima datos del maritima
     * @return objeto con los datos del maritima ya almacenados
     */
    @PostMapping
    public ResponseEntity<?> insertarMaritima(@RequestBody MaritimaDto maritima) {
        maritima = service.guardarMaritima(maritima);
        if (maritima == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(maritima);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        boolean usuario = service.eliminar(id);
        if(usuario == true){
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody MaritimaDto u){
        MaritimaDto p = service.obtenerMaritima(id);
        if(p == null){
            return ResponseEntity.noContent().build();
        }
        p = service.guardarMaritima(u);
        if(p == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(p);
    }
}

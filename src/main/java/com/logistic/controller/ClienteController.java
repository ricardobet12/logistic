package com.logistic.controller;

import com.logistic.dto.ClientesDto;
import com.logistic.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v.1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    /**
     * metodo para listar todos los usuario de la base de datos.
     *
     * @return lista de usuarios guardados en la base de datos
     */
    @GetMapping("/")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(service.getClientes());
    }

    /**
     * Servicio para obtener a un cliente por su id.
     * @param id id del cliente
     * @return objeto con la información del cliente
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable("id") Long id) {
        ClientesDto cliente = service.getCliente(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    /**
     * Metodo para insertar un cliente en la base de datos.
     * @param cliente datos del cliente
     * @return objeto con los datos del clientes ya almacenados
     */
    @PostMapping
    public ResponseEntity<?> insertarCliente(@RequestBody ClientesDto cliente) {
        cliente = service.guardarCliente(cliente);
        if (cliente == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(cliente);
    }
}

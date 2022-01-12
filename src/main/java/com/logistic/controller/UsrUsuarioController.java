
package com.logistic.controller;


import com.logistic.services.UsrUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v.1/usuarios")
public class UsrUsuarioController {

    /**
     * usuarios service.
     */
    @Autowired
    private UsrUsuariosService usrUsuariosService;


    /**
     * metodo para eliminar un usuario de la base de datos.
     *
     * @param id del usuario
     * @return objeto eliminado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(usrUsuariosService.eliminarUsuraio(id));
    }

    /**
     * metodo para listar todos los usuario de la base de datos.
     *
     * @return lista de usuarios guardados en la base de datos
     */
    @GetMapping("/")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(usrUsuariosService.listarTodos());
    }
}

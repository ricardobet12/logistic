package com.logistic.util;

import com.logistic.security.entity.Rol;
import com.logistic.security.enums.RolNombre;
import com.logistic.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
         Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
         rolAdmin.setId(1);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolUser.setId(2);
        Optional<Rol> rolOptional = rolService.getByRolNombre(RolNombre.ROLE_ADMIN);
        if (!rolOptional.isPresent()){
            rolService.save(rolAdmin);
            rolService.save(rolUser);
        }
    }
}

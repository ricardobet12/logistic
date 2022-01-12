package com.logistic.services;


import com.logistic.dto.UsuarioDto;

import java.util.List;

public interface UsuariosService {

    /**
     * metodo para eliminar un usuario de la base ded datos.
     *
     * @param id del usuario
     * @return objeto de tipo usuarioDTO que fue eliminado de la base de datos
     */
    UsuarioDto eliminarUsuraio(Integer id);

    /**
     * metodo para listar a todos los usuarios de la base de datos.
     *
     * @return lista de usuarios almacenados en la base de datos
     */
    List<UsuarioDto> listarTodos();

}


package com.logistic.services.impl;

import com.logistic.dto.UsrUsuarioDTO;
import com.logistic.entity.UsrUsuarios;
import com.logistic.exceptions.responses.BadRequestException;
import com.logistic.repository.UsuarioRepository;
import com.logistic.services.UsrUsuariosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsrUsuariosImlp implements UsrUsuariosService {

    /**
     * repository de usuarios.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;
    /**
     * model mapper.
     */
    @Autowired
    private ModelMapper mapper;

    /**
     * constructor.
     *
     * @param usuarioRepository repo usuarios
     * @param mapper model mapper
     */
    public UsrUsuariosImlp(UsuarioRepository usuarioRepository, ModelMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    /**
     * metodo para eliminar un usuario de la base ded datos.
     *
     * @param id del usuario
     * @return objeto de tipo usuarioDTO que fue eliminado de la base de datos
     */
    @Override
    public UsrUsuarioDTO eliminarUsuraio(Integer id) {
        Optional<UsrUsuarios> usu = usuarioRepository.findById(id);

        if (usu.isPresent()) {
            usuarioRepository.deleteById(usu.get().getIdUsuario());
            return mapper.map(usu.get(), UsrUsuarioDTO.class);
        }
        throw new BadRequestException("Ocurrio un error al eliminar el usuario");
    }

    /**
     * metodo para listar a todos los usuarios de la base de datos.
     *
     * @return lista de usuarios almacenados en la base de datos
     */
    @Override
    public List<UsrUsuarioDTO> listarTodos() {
        List<UsrUsuarios> listaUsuario = usuarioRepository.findAll();
        List<UsrUsuarioDTO> respuesta = new ArrayList<>();

        if (!listaUsuario.isEmpty()) {
            for (UsrUsuarios usu : listaUsuario) {
                respuesta.add(mapper.map(usu, UsrUsuarioDTO.class));
            }
            return respuesta;
        }
        throw new BadRequestException("No hay usuarios en la base de datos");
    }
}

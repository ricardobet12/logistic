package com.logistic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDto {

    private Integer idUsuario;
    private String nombreUsuario;
    private List<RolDto> roles;
    private String contrasena;
    private String nombres;
    private String apellidos;
}

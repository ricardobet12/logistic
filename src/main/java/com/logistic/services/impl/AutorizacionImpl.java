package com.logistic.services.impl;

import com.logistic.entity.Usuarios;
import com.logistic.exceptions.responses.BadRequestException;
import com.logistic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class AutorizacionImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Usuarios usu = usuarioRepository.findByNombreUsuario(userId);

        if (usu != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            usu.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getNombre()));
            });
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(usu.getNombreUsuario(), usu.getContrasena(), authorities);
            return userDetails;
        }
        throw new BadRequestException("El usuario no existe");
    }
}

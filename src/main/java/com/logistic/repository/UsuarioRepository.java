package com.logistic.repository;

import com.logistic.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    
    Usuarios findByNombreUsuario(String nombreUsuario);

}


package com.logistic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsrUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    /**
     * nombe del usuario.
     */
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    
    /**
     * nombe del usuario.
     */
    @Column(name = "nombres")
    private String nombres;
    
    /**
     * nombe del usuario.
     */
    @Column(name = "apellidos")
    private String apellidos;
    /**
     * contraseña del usuario.
     */
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;

    /**
     * lista de roles asociados al usuario.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns
            = @JoinColumn(name = "id_usuario",
                    referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol",
                    referencedColumnName = "id_rol"))
    private List<UsrRol> roles;
}

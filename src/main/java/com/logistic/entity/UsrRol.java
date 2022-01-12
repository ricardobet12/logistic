package com.logistic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class UsrRol implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id del rol.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol")
    private Integer idRol;
    /**
     * nombre del rol.
     */
    @Column(name = "nombre")
    private String nombre;

}

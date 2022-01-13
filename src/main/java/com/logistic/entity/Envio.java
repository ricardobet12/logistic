package com.logistic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "envio")
public class Envio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_envio")
    private Long idEnvio;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "fecha_entrada")
    private Date fechaEntrada;

    @Column(name = "precio_envio")
    private Double precioEnvio;

    @Column(name = "descuento")
    private Double descuento;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Clientes fkCliente;

    @Column(name = "numero_guia")
    private Integer numeroGuia;

    @Column(name = "bodega")
    private Integer bodega;
}

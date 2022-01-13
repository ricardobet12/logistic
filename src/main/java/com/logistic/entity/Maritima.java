package com.logistic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "logistica_maritima")
public class Maritima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_logistica_maritima")
    private Long idLogisticaMaritima;

    @Column(name = "bodega_entrega")
    private String bodegaEntrega;

    @Column(name = "placa_vehiculo")
    private String placaVehiculo;

    @ManyToOne
    @JoinColumn(name = "fk_envio")
    private Envio fkEnvio;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;
}

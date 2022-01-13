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
@Table(name = "logistica_terrestre")
public class Terrestre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_logistica_terrestre")
    private Long idLogisticaTerrestre;

    @Column(name = "puerto_entrega")
    private Integer puertoEntrega;

    @Column(name = "numero_flota")
    private Integer numeroFlota;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;

    @ManyToOne
    @JoinColumn(name = "fk_envio")
    private Envio fkEnvio;
}

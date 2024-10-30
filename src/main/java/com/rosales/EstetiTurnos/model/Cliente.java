
package com.rosales.EstetiTurnos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String numero_celular;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, String numero_celular) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_celular = numero_celular;
    }

    
    
}

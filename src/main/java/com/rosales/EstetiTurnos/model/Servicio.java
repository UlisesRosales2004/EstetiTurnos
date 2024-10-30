
package com.rosales.EstetiTurnos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_servicio;
    private String nombre;
    private String descripcion;
    private int tiempo_estimado;
    @ManyToMany(mappedBy = "lista_serv")  
    @JsonIgnore
    private List<Turno> turnos;

    public Servicio() {
    }

    public Servicio(Long id_servicio, String nombre, String descripcion, int tiempo_estimado, List<Turno> turnos) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo_estimado = tiempo_estimado;
        this.turnos = turnos;
    }



    
    
}

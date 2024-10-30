package com.rosales.EstetiTurnos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_turno;
    private LocalDate fecha;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private String cliente_nombre;
    private String cliente_celular;

    @ManyToMany
    @JoinTable(
            name = "turno_servicios",
            joinColumns = @JoinColumn(name = "turno_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private List<Servicio> lista_serv;

    public Turno() {
    }

    public Turno(Long id_turno, LocalDate fecha, LocalTime hora_inicio, String cliente_nombre, String cliente_celular, List<Servicio> lista_serv) {
        this.id_turno = id_turno;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.cliente_nombre = cliente_nombre;
        this.cliente_celular = cliente_celular;
        this.lista_serv = lista_serv;
    }

    public LocalTime calcularHoraFin() {
        
        int tiempoTotal = 0;
        for (Servicio servicio : lista_serv) {
        tiempoTotal += servicio.getTiempo_estimado();
            System.out.println(servicio.getId_servicio());
        }
        LocalTime horaFinCalculada = hora_inicio.plusMinutes(tiempoTotal);
        return horaFinCalculada;
    }

}

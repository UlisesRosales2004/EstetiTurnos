package com.rosales.EstetiTurnos.service;

import com.rosales.EstetiTurnos.model.Servicio;
import com.rosales.EstetiTurnos.model.Turno;
import com.rosales.EstetiTurnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepo;
    @Autowired
    IServicioService servServi;

    @Override
    public List<Turno> TraerTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public Turno AgendarTurno(Turno turno) {
        
        turno.setLista_serv(TraerTodosLosServicios(turno));
        turno.setHora_fin(turno.calcularHoraFin());
        if (VerificarDisponibilidad(turno)) {
            return turnoRepo.save(turno);
        } else {
            throw new IllegalArgumentException("El horario no está disponible.");
        }
    }

    @Override
    public void EliminarTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public boolean VerificarDisponibilidad(Turno turno) {
        List<Turno> turnosExistentes = turnoRepo.findByFecha(turno.getFecha());

        for (Turno turnoExistente : turnosExistentes) {
            LocalTime inicioExistente = turnoExistente.getHora_inicio();
            LocalTime finExistente = turnoExistente.getHora_fin();

            if (turno.getHora_inicio().isBefore(finExistente) && turno.getHora_fin().isAfter(inicioExistente)) {
                return false;  
            }
        }
        return true; 
    }

    @Override
    public List<Servicio> TraerTodosLosServicios(Turno turno) {
        List<Servicio> serviciosCompletos=new ArrayList();
        List<Servicio> serviciosPorNumero=turno.getLista_serv();
        for(Servicio serv: serviciosPorNumero){
            serviciosCompletos.add(servServi.TraerServicio(serv.getId_servicio()));
        }
        return serviciosCompletos;
    }

    @Override
    public List<Turno> TraerPorFecha(LocalDate fecha) {
        List<Turno> ListaTurnos=turnoRepo.findByFecha(fecha);
        System.out.println(ListaTurnos);
        return ListaTurnos;
    }
}


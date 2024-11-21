
package com.rosales.EstetiTurnos.service;

import com.rosales.EstetiTurnos.model.Servicio;
import com.rosales.EstetiTurnos.model.Turno;
import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    
    public List<Turno> TraerTurnos();
    public Turno AgendarTurno(Turno turno);
    public void EliminarTurno(Long id);
    public boolean VerificarDisponibilidad(Turno turno);
    public List<Servicio> TraerTodosLosServicios(Turno turno);
    public List<Turno> TraerPorFecha(LocalDate fecha);
}

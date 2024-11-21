
package com.rosales.EstetiTurnos.controller;

import com.rosales.EstetiTurnos.model.Turno;
import com.rosales.EstetiTurnos.service.ITurnoService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class TurnoController {
    
    @Autowired
    ITurnoService turnoServ;
    
    @PostMapping("/turno/crear")
    public void Agendarturno(@RequestBody Turno turno){
        turnoServ.AgendarTurno(turno);
    }
    
    @GetMapping("/turnos/traer")
    @ResponseBody
    public List<Turno> TraerTurnos(){
        return turnoServ.TraerTurnos();
    }
    
    @DeleteMapping("/turno/eliminar/{id}")
    public void EliminarTurno(@PathVariable Long id){
        turnoServ.EliminarTurno(id);
    }
    @GetMapping("/turno/traerPorFecha/{fecha}")
    public List<Turno> TraerPorFecha(@PathVariable LocalDate fecha){
        return turnoServ.TraerPorFecha(fecha);
    }
    
}

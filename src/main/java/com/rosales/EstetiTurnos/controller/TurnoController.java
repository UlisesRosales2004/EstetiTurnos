
package com.rosales.EstetiTurnos.controller;

import com.rosales.EstetiTurnos.model.Turno;
import com.rosales.EstetiTurnos.service.ITurnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    
    @DeleteMapping("/turno/eliminar")
    public void EliminarTurno(Long id){
        turnoServ.EliminarTurno(id);
    }
    
}


package com.rosales.EstetiTurnos.controller;

import com.rosales.EstetiTurnos.model.Servicio;
import com.rosales.EstetiTurnos.service.IServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioController {
    @Autowired
    IServicioService servicioServ;
    
    @PostMapping("/servicio/crear")
    public void CrearServicio(@RequestBody Servicio serv){
        servicioServ.CrearServicio(serv);
    }
    
    @GetMapping("/servicio/traer")
    @ResponseBody
    public List<Servicio> TraerServicios(){
        return servicioServ.TraerServicios();
    }
    
    @DeleteMapping("/servicio/eliminiar/{id}")
    public void EliminarServicio(@PathVariable Long id){
        servicioServ.EliminarServicio(id);
    }
}


package com.rosales.EstetiTurnos.service;

import com.rosales.EstetiTurnos.model.Servicio;
import java.util.List;


public interface IServicioService {
    
    public List<Servicio> TraerServicios();
    public void CrearServicio(Servicio serv);
    public void EliminarServicio(Long id);
    public Servicio TraerServicio(Long id);
    
}

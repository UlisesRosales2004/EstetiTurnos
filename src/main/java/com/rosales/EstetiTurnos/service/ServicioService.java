
package com.rosales.EstetiTurnos.service;

import com.rosales.EstetiTurnos.model.Servicio;
import com.rosales.EstetiTurnos.repository.IServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService implements IServicioService {

    @Autowired
    IServicioRepository servRepo;
    
    @Override
    public List<Servicio> TraerServicios() {
        return servRepo.findAll();
    }

    @Override
    public void CrearServicio(Servicio serv) {
        servRepo.save(serv);
    }

    @Override
    public void EliminarServicio(Long id) {
        servRepo.deleteById(id);
    }

    @Override
    public Servicio TraerServicio(Long id) {
        return servRepo.findById(id).orElse(null);
    }
    
}

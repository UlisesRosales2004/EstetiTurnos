
package com.rosales.EstetiTurnos.repository;

import com.rosales.EstetiTurnos.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio,Long>{
    
}

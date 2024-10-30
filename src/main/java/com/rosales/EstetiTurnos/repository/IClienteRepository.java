
package com.rosales.EstetiTurnos.repository;

import com.rosales.EstetiTurnos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long>{
    
}

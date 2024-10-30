
package com.rosales.EstetiTurnos.service;

import com.rosales.EstetiTurnos.model.Cliente;
import com.rosales.EstetiTurnos.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository clieRepo;
    
    @Override
    public List<Cliente> TraerClintes() {
        return clieRepo.findAll();
    }

    @Override
    public void CrearCliente(Cliente clie) {
        clieRepo.save(clie);
    }

    @Override
    public void EliminarCliente(Long id) {
        clieRepo.deleteById(id);
    }
    
}

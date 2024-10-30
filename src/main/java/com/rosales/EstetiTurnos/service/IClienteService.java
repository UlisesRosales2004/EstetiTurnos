
package com.rosales.EstetiTurnos.service;

import com.rosales.EstetiTurnos.model.Cliente;
import java.util.List;

public interface IClienteService {
    public List<Cliente> TraerClintes();
    public void CrearCliente(Cliente clie);
    public void EliminarCliente(Long id);
}

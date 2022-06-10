/**
 * 
 */
package com.nttdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.model.Cliente;
import com.nttdata.repository.IClienteRepo;
import com.nttdata.repository.IGenericRepo;
import com.nttdata.service.IClienteServicio;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Service
public class ClienteServicioImpl extends CRUDImpl<Cliente, Integer> implements IClienteServicio {

	@Autowired
	private IClienteRepo clienteRepo;

	@Override
	protected IGenericRepo<Cliente, Integer> getRepo() {
		return clienteRepo;
	}

}

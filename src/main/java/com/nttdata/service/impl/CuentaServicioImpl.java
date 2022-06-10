/**
 * 
 */
package com.nttdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.model.Cuenta;
import com.nttdata.repository.ICuentaRepo;
import com.nttdata.repository.IGenericRepo;
import com.nttdata.service.ICuentaServicio;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Service
public class CuentaServicioImpl extends CRUDImpl<Cuenta, Long> implements ICuentaServicio {

	@Autowired
	private ICuentaRepo cuentaRepo;

	@Override
	protected IGenericRepo<Cuenta, Long> getRepo() {
		return cuentaRepo;
	}

}

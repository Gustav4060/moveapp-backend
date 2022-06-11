/**
 * 
 */
package com.nttdata.service;

import com.nttdata.dto.MovimientoDeCuentasDto;
import com.nttdata.model.Movimiento;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public interface IMovimientoCuentasServicio {
	Movimiento validaRegistroMovimiento(MovimientoDeCuentasDto movimientoDeCuentasDto) throws Exception;
}

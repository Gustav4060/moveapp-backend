/**
 * 
 */
package com.nttdata.enumeration;

import lombok.Getter;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public enum TipoMovimientoEnum {
	
	R("Retiro"), D("Deposito");

	@Getter
	private String descripcion;

	TipoMovimientoEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	
}

/**
 * 
 */
package com.nttdata.enumeration;

import lombok.Getter;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public enum TipoCuentaEnum {

	A("AHORRO"), C("CORRIENTE");

	@Getter
	private String descripcion;

	TipoCuentaEnum(String descripcion) {
		this.descripcion = descripcion;
	}

}

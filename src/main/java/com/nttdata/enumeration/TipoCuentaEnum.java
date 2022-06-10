/**
 * 
 */
package com.nttdata.enumeration;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public enum TipoCuentaEnum {

	A("AHORRO"), C("CORRIENTE");

	
	private String descripcion;

	TipoCuentaEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}

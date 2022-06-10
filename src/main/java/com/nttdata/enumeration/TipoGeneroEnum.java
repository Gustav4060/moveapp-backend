/**
 * 
 */
package com.nttdata.enumeration;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public enum TipoGeneroEnum {

	M("Masculino"), F("Femenino");

	
	private String tipoGenero;

	TipoGeneroEnum(String tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

	public String getTipoGenero() {
		return tipoGenero;
	}
	
}

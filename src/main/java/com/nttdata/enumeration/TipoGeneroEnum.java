/**
 * 
 */
package com.nttdata.enumeration;

import lombok.Getter;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public enum TipoGeneroEnum {

	M("Masculino"), F("Femenino");

	@Getter
	private String tipoGenero;

	TipoGeneroEnum(String tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

		
}

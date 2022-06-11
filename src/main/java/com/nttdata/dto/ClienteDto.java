/**
 * 
 */
package com.nttdata.dto;

import lombok.Data;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Data
public class ClienteDto {

	
	private Long clienteId;
	
	private String nombre;

	private String genero;

	private int edad;

	private String identificacion;

	private String direccion;
	
	private String telefono;

	private String contrasenia;

	private String estado;

	
}

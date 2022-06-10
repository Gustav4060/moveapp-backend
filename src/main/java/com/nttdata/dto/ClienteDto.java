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

	private String nombre;

	private String genero;

	private int edad;

	private String identificacion;

	private String direccion;
	
	private String telefono;

	private Integer clienteId;

	private String contraseña;

	private String estado;

	
}

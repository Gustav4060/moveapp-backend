/**
 * 
 */
package com.nttdata.dto;

import com.nttdata.enumeration.TipoGeneroEnum;

import lombok.Data;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Data
public class ClienteDto {

	private Long id;

	private String nombre;

	private TipoGeneroEnum genero;

	private int edad;

	private String identificacion;

	private String direccion;

	private String telefono;

	private String contrasenia;

	private String estado;

}

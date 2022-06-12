/**
 * 
 */
package com.nttdata.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nttdata.enumeration.TipoGeneroEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Data
public class ClienteDto {

	private Long id;

	@NotNull(message = "Nombre no puede ser nulo")
	@Schema(description = "nombres del cliente")
	@Size(min = 3, message = "{nombres.size}")
	private String nombre;
	
	@NotNull
	private TipoGeneroEnum genero;

	@NotNull
	@Min(value=18, message="Edad minima 18")
	private int edad;
	
	@NotNull
	@Size(min = 10, max = 10, message = "Cedula debe tener 10 caracteres")
	private String identificacion;
	
	@NotNull
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	private String direccion;

	@NotNull
	@Size(min = 10, max = 10, message = "Telefono debe tener 10 caracteres")
	private String telefono;

	@NotNull
	private String contrasenia;

	@NotNull
	private Boolean estado;

}

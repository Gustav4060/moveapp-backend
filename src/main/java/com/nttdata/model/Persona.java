/**
 * 
 */
package com.nttdata.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@MappedSuperclass
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "genero", nullable = false, length = 1)
	private String genero;

	@Column(name = "edad", nullable = false)
	private int edad;

	@Column(name = "identificacion", nullable = false, length = 100)
	private String identificacion;

	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;

	@Column(name = "telefono", nullable = false, length = 100)
	private String telefono;

}

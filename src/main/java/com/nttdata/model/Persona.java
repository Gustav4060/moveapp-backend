/**
 * 
 */
package com.nttdata.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.nttdata.enumeration.TipoGeneroEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@MappedSuperclass
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "genero", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private TipoGeneroEnum genero;

	@Column(name = "edad", nullable = false)
	private int edad;

	@Column(name = "identificacion", nullable = false, length = 10)
	private String identificacion;

	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;

	@Column(name = "telefono", nullable = false, length = 10)
	private String telefono;

}

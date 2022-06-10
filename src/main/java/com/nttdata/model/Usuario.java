/**
 * 
 */
package com.nttdata.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gustavo.parco
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "usuario")
public class Usuario extends Persona {
	private String nombre;
}

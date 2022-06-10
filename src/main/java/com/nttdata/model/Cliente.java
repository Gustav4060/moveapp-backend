package com.nttdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cliente")
public class Cliente extends Persona {

	/*
	 * @Id
	 * 
	 * @Column(name = "cliente_id", nullable = false)
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer
	 * clienteId;
	 */

	@Column(name = "contraseña", nullable = false)
	private String contraseña;

	@Column(name = "estado", nullable = false)
	private String estado;

}

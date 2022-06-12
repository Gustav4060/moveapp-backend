package com.nttdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente extends Persona {

	@Column(name = "contrasenia", nullable = false)
	private String contrasenia;

	@Column(name = "estado", nullable = false)
	private Boolean estado;

}

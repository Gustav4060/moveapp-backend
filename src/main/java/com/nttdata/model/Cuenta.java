/**
 * 
 */
package com.nttdata.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nttdata.enumeration.TipoCuentaEnum;

import lombok.Data;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroCuenta;

	@Column(name = "tipo_cuenta", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private TipoCuentaEnum tipoCuenta;

	@Column(name = "saldo_inicial", nullable = false)
	private BigDecimal saldoInicial;

	@Column(name = "estado", nullable = false)
	private Boolean estado;

	@Column(name = "cliente_id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false, updatable = false, insertable = false)
   	private Cliente cliente;

	

}

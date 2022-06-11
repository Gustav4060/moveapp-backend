/**
 * 
 */
package com.nttdata.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nttdata.enumeration.TipoCuentaEnum;
import com.nttdata.model.Cliente;

import lombok.Data;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Data
public class CuentaDto {

	private Long numeroCuenta;

	private TipoCuentaEnum tipoCuenta;

	private BigDecimal saldoInicial;

	private Boolean estado;

	private Long id;

	@JsonIgnore
	private Cliente cliente;

}

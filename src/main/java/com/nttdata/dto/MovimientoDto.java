/**
 * 
 */
package com.nttdata.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.nttdata.enumeration.TipoCuentaEnum;

import lombok.Data;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Data
public class MovimientoDto {

	private Long idMovimientos;

	private LocalDateTime fecha;

	private TipoCuentaEnum tipoMovimiento;

	private BigDecimal valor;

	private BigDecimal saldo;

}

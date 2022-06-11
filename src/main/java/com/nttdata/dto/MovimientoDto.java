/**
 * 
 */
package com.nttdata.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;

import com.nttdata.enumeration.TipoMovimientoEnum;

import lombok.Data;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Data
public class MovimientoDto {

	private Long idMovimientos;

	private LocalDateTime fecha;

	private TipoMovimientoEnum tipoMovimiento;

	private BigDecimal valor;

	private BigDecimal saldo;

	private Long numeroCuenta;

}

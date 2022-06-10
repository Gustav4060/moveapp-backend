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

	public Long getIdMovimientos() {
		return idMovimientos;
	}

	public void setIdMovimientos(Long idMovimientos) {
		this.idMovimientos = idMovimientos;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public TipoCuentaEnum getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoCuentaEnum tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}

/**
 * 
 */
package com.nttdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteMovimientosDto {
	
	private String fecha;
	
	private String cliente;
	
	private String numeroCuenta;
	
	private String tipo;
	
	private String saldoInicial;
	
	private String estado;
	
	private String movimiento;
	
	private String saldoDisponible;
	
	

}

/**
 * 
 */
package com.nttdata.service;

import java.time.LocalDate;
import java.util.List;

import com.nttdata.dto.ReporteMovimientosDto;
import com.nttdata.model.Movimiento;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public interface IMovimientoServicio extends ICRUD<Movimiento, Long> {
	List<ReporteMovimientosDto> reporteMovimientos(LocalDate fechaInicio, LocalDate fechaFin, Long idCliente);
}

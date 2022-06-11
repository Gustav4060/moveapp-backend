/**
 * 
 */
package com.nttdata.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dto.ReporteMovimientosDto;
import com.nttdata.model.Movimiento;
import com.nttdata.repository.IGenericRepo;
import com.nttdata.repository.IMovimientoRepo;
import com.nttdata.service.IMovimientoServicio;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Service
public class MovimientoServicio extends CRUDImpl<Movimiento, Long> implements IMovimientoServicio {

	@Autowired
	private IMovimientoRepo movimientoRepo;

	@Override
	protected IGenericRepo<Movimiento, Long> getRepo() {
		return movimientoRepo;
	}

	@Override
	public List<ReporteMovimientosDto> reporteMovimientos(LocalDate fechaInicio, LocalDate fechaFin, Long idCliente) {
		List<ReporteMovimientosDto> consultas = new ArrayList<>();
		movimientoRepo.reporteMovimientos(fechaInicio,fechaFin,idCliente).forEach(x -> {

			ReporteMovimientosDto rm = new ReporteMovimientosDto(String.valueOf(x[0]), String.valueOf(x[1]),
					String.valueOf(x[2]), String.valueOf(x[3]), String.valueOf(x[4]), String.valueOf(x[5]),
					String.valueOf(x[6]), String.valueOf(x[7]));

			consultas.add(rm);
		});
		return consultas;
	}

}

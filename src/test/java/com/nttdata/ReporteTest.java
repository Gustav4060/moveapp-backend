/**
 * 
 */
package com.nttdata;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nttdata.dto.ReporteMovimientosDto;
import com.nttdata.service.IMovimientoServicio;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@SpringBootTest
class ReporteTest {

	@Autowired
	IMovimientoServicio movimientoServicio;

	@Test
	public void generarReporteMovimientos() {
		List<ReporteMovimientosDto> reporteMovimientosDtos = movimientoServicio
				.reporteMovimientos(LocalDate.parse("2020-01-01"), LocalDate.parse("2022-12-31"), 5L);
		assertThat(reporteMovimientosDtos).size().isGreaterThan(0);
	}

}

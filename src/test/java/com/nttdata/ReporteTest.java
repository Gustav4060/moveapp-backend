/**
 * 
 */
package com.nttdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
	void generarReporteMovimientos() {
		List<ReporteMovimientosDto> reporteMovimientosDtos = movimientoServicio
				.reporteMovimientos(LocalDate.parse("2020-01-01"), LocalDate.parse("2022-12-31"), 1L);
		//assertThat(reporteMovimientosDtos).size().isNegative();
		assertNotNull(reporteMovimientosDtos);
	}

}

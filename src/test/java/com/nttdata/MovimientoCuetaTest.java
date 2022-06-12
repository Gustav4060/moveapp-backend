/**
 * 
 */
package com.nttdata;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nttdata.dto.MovimientoDeCuentasDto;
import com.nttdata.enumeration.TipoMovimientoEnum;
import com.nttdata.model.Movimiento;
import com.nttdata.service.IMovimientoCuentasServicio;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@SpringBootTest
class MovimientoCuetaTest {

	@Autowired
	IMovimientoCuentasServicio movimientoCuentasServicio;

	/*
	 * @Test void registroMovimientoCuenta() { MovimientoDeCuentasDto mc = new
	 * MovimientoDeCuentasDto(); mc.setNumeroCuenta(1L);
	 * mc.setTipoMovimiento(TipoMovimientoEnum.R);
	 * mc.setValor(BigDecimal.valueOf(10.00)); try { Movimiento m =
	 * movimientoCuentasServicio.validaRegistroMovimiento(mc);
	 * assertNotEquals(mc.getValor(), m.getValor());
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

}

/**
 * 
 */
package com.nttdata;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nttdata.enumeration.TipoCuentaEnum;
import com.nttdata.exception.MovimientosException;
import com.nttdata.model.Cuenta;
import com.nttdata.service.ICuentaServicio;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@SpringBootTest
class CuentaTest {

	@Autowired
	ICuentaServicio cuentaServicio;
	
	
	/*
	 * @Test void crearCuenta() { Cuenta cuenta= new Cuenta();
	 * cuenta.setIdCliente(1L); cuenta.setEstado(true);
	 * cuenta.setSaldoInicial(BigDecimal.valueOf(10000));
	 * cuenta.setTipoCuenta(TipoCuentaEnum.A); try {
	 * cuenta=cuentaServicio.registrar(cuenta);
	 * assertNotNull(cuentaServicio.listarPorId(cuenta.getNumeroCuenta())); } catch
	 * (MovimientosException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
}

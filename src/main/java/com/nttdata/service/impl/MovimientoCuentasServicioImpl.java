/**
 * 
 */
package com.nttdata.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dto.MovimientoDeCuentasDto;
import com.nttdata.enumeration.TipoMovimientoEnum;
import com.nttdata.exception.MovimientosException;
import com.nttdata.model.Cuenta;
import com.nttdata.model.Movimiento;
import com.nttdata.service.ICuentaServicio;
import com.nttdata.service.IMovimientoCuentasServicio;
import com.nttdata.service.IMovimientoServicio;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@Service
public class MovimientoCuentasServicioImpl implements IMovimientoCuentasServicio {

	public static final BigDecimal LIMITE_DIARIO_RETIRO = BigDecimal.valueOf(1000L);

	@Autowired
	private ICuentaServicio cuentaServicio;

	@Autowired
	private IMovimientoServicio movimientoServicio;

	@Transactional
	@Override
	public synchronized Movimiento validaRegistroMovimiento(MovimientoDeCuentasDto movimientoDeCuentasDto)
			throws MovimientosException {

		Movimiento movimiento = new Movimiento();
		movimiento.setFecha(LocalDateTime.now());
		movimiento.setNumeroCuenta(movimientoDeCuentasDto.getNumeroCuenta());
		movimiento.setTipoMovimiento(movimientoDeCuentasDto.getTipoMovimiento());

		List<Movimiento> movimientos = movimientoServicio
				.buscarMovimientosPorNumeroDeCuenta(movimientoDeCuentasDto.getNumeroCuenta());

		movimiento.setSaldo(obtenerSaldoActual(movimientos, movimientoDeCuentasDto.getNumeroCuenta()));

		movimiento.setValor(obtenerValorPorTipoMovimiento(movimientoDeCuentasDto.getTipoMovimiento(),
				movimientoDeCuentasDto.getValor()));

		movimiento.setSaldo(movimiento.getSaldo().add(movimiento.getValor()));

		if (movimiento.getSaldo().compareTo(BigDecimal.ZERO) <= 0
				&& movimiento.getTipoMovimiento().equals(TipoMovimientoEnum.R)) {
			throw new MovimientosException("Saldo no disponible");
		}

		if (movimiento.getTipoMovimiento().equals(TipoMovimientoEnum.R)
				&& validarLimiteDiarioRetiro(movimientos, movimientoDeCuentasDto.getValor())) {
			throw new MovimientosException("Cupo Diario Excedido");
		}

		movimientoServicio.registrar(movimiento);

		return movimiento;
	}

	private BigDecimal obtenerValorPorTipoMovimiento(TipoMovimientoEnum tipoMovimiento, BigDecimal valor) {
		return tipoMovimiento.equals(TipoMovimientoEnum.R) ? valor.multiply(BigDecimal.valueOf(-1.0)) : valor;
	}

	private BigDecimal obtenerSaldoActual(List<Movimiento> movimientos, Long numeroCuenta) throws MovimientosException {
		BigDecimal saldoActual = BigDecimal.ZERO;
		if (movimientos.isEmpty()) {
			Cuenta cuenta = cuentaServicio.listarPorId(numeroCuenta);
			saldoActual = cuenta.getSaldoInicial();
		} else {
			Optional<Movimiento> ultimoMovimiento = movimientos.stream()
					.max(Comparator.comparing(Movimiento::getFecha));
			if (ultimoMovimiento.isPresent()) {
				saldoActual = ultimoMovimiento.get().getSaldo();
			}
		}
		return saldoActual;
	}

	private boolean validarLimiteDiarioRetiro(List<Movimiento> movimientos, BigDecimal valorRetiro) {
		BigDecimal valotMovimientosDeHoy = movimientos.stream()
				.filter(m -> m.getFecha().toLocalDate().equals(LocalDate.now())
						&& m.getTipoMovimiento().equals(TipoMovimientoEnum.R))
				.map(val -> val.getValor().multiply(BigDecimal.valueOf(-1.0))).reduce(BigDecimal.ZERO, BigDecimal::add);
		return valotMovimientosDeHoy.add(valorRetiro).compareTo(LIMITE_DIARIO_RETIRO) > 0;

	}

}

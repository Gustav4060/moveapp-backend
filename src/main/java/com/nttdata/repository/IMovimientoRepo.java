/**
 * 
 */
package com.nttdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nttdata.model.Movimiento;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public interface IMovimientoRepo extends IGenericRepo<Movimiento, Long> {

	@Query(value = "select m.fecha, c.nombre, cu.numero_cuenta, cu.tipo_cuenta, cu.saldo_inicial, cu.estado, m.valor, m.saldo "
			+ "from cliente c, cuenta cu, movimiento m where c.id = cu.cliente_id "
			+ "and cu.numero_cuenta = m.numero_cuenta and m.fecha between (:p1) and (:p2) "
			+ "and c.id = (:p3)", nativeQuery = true)
	List<Object[]> reporteMovimientos(@Param("p1") LocalDate fechaInicio, @Param("p2") LocalDate fechaFin,
			@Param("p3") Long idCliente);
	
	List<Movimiento> findByNumeroCuenta(Long numeroCuenta);
	
	

}

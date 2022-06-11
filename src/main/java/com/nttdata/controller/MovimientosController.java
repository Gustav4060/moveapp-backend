/**
 * 
 */
package com.nttdata.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.dto.MovimientoDeCuentasDto;
import com.nttdata.dto.MovimientoDto;
import com.nttdata.dto.ReporteMovimientosDto;
import com.nttdata.exception.ModeloNotFoundException;
import com.nttdata.model.Movimiento;
import com.nttdata.service.IMovimientoCuentasServicio;
import com.nttdata.service.IMovimientoServicio;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IMovimientoServicio movimientoServicio;
	
	
	@Autowired
	private IMovimientoCuentasServicio movimientoCuentasServicio;

	/**
	 * Obtiene la lista de Movimientoss
	 * 
	 * @return -dto de Movimientoss
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<MovimientoDto>> listar() throws Exception {
		List<MovimientoDto> lista = movimientoServicio.listar().stream().map(p -> mapper.map(p, MovimientoDto.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	/**
	 * Lista por identificador de Movimientos
	 * 
	 * @param id identificador del Movimientos
	 * @return Dto de Movimientos
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<MovimientoDto> listarPorId(@PathVariable("id") Long id) throws Exception {
		MovimientoDto dtoResponse;
		Movimiento obj = movimientoServicio.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		} else {
			dtoResponse = mapper.map(obj, MovimientoDto.class); // PacienteDTO
		}

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	/**
	 * Registra el Movimientos
	 * 
	 * @param dtoRequest dto del Movimientos
	 * @return Movimientos dto
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<MovimientoDto> registrar(@Valid @RequestBody MovimientoDto dtoRequest) throws Exception {
		Movimiento p = mapper.map(dtoRequest, Movimiento.class);
		Movimiento obj = movimientoServicio.registrar(p);
		MovimientoDto dtoResponse = mapper.map(obj, MovimientoDto.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
	}

	/**
	 * Modifica el Movimientos
	 * 
	 * @param dtoRequest deto de Movimientos
	 * @return dto de Movimientos modificado
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<MovimientoDto> modificar(@RequestBody MovimientoDto dtoRequest) throws Exception {
		Movimiento pac = movimientoServicio.listarPorId(dtoRequest.getIdMovimientos());
		if (pac == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + dtoRequest.getIdMovimientos());
		}
		Movimiento p = mapper.map(dtoRequest, Movimiento.class);
		Movimiento obj = movimientoServicio.modificar(p);
		MovimientoDto dtoResponse = mapper.map(obj, MovimientoDto.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	/**
	 * Elimina Movimientos por id
	 * 
	 * @param id identificador del Movimientos
	 * @return retorna vacio
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception {
		Movimiento mov = movimientoServicio.listarPorId(id);

		if (mov == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		movimientoServicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/reporte")
	public ResponseEntity<List<ReporteMovimientosDto>> reporte(@RequestParam String fechaInicio,
			@RequestParam String fechaFin, @RequestParam Long idCliente) {
		List<ReporteMovimientosDto> consultas = new ArrayList<>();
		consultas = movimientoServicio.reporteMovimientos(LocalDate.parse(fechaInicio),
				LocalDate.parse(fechaFin), idCliente);
		return new ResponseEntity<>(consultas, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/movimientodecuenta")
	public ResponseEntity<MovimientoDto> registrar(@Valid @RequestBody MovimientoDeCuentasDto dtoRequest) throws Exception {
		Movimiento obj = movimientoCuentasServicio.validaRegistroMovimiento(dtoRequest);
		MovimientoDto dtoResponse = mapper.map(obj, MovimientoDto.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
	}

}

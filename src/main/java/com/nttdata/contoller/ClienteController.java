/**
 * 
 */
package com.nttdata.contoller;

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
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.dto.ClienteDto;
import com.nttdata.exception.ModeloNotFoundException;
import com.nttdata.model.Cliente;
import com.nttdata.service.IClienteServicio;


/**
 * @author gustavoefrainparcosanchez
 *
 */

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IClienteServicio clienteServicio;

	/**
	 * Obtiene la lista de Clientes
	 * 
	 * @return -dto de Clientes
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<ClienteDto>> listar() throws Exception {
		List<ClienteDto> lista = clienteServicio.listar().stream().map(p -> mapper.map(p, ClienteDto.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	/**
	 * Lista por identificador de Cliente
	 * 
	 * @param id identificador del Cliente
	 * @return Dto de Cliente
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> listarPorId(@PathVariable("id") Long id) throws Exception {
		ClienteDto dtoResponse;
		Cliente obj = clienteServicio.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		} else {
			dtoResponse = mapper.map(obj, ClienteDto.class); // PacienteDTO
		}

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	/**
	 * Registra el Cliente
	 * 
	 * @param dtoRequest dto del Cliente
	 * @return Cliente dto
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<ClienteDto> registrar(@Valid @RequestBody ClienteDto dtoRequest) throws Exception {
		Cliente p = mapper.map(dtoRequest, Cliente.class);
		Cliente obj = clienteServicio.registrar(p);
		ClienteDto dtoResponse = mapper.map(obj, ClienteDto.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
	}

	/**
	 * Modifica el Cliente
	 * 
	 * @param dtoRequest deto de Cliente
	 * @return dto de Cliente modificado
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<ClienteDto> modificar(@RequestBody ClienteDto dtoRequest) throws Exception {
		Cliente pac = clienteServicio.listarPorId(dtoRequest.getId());

		if (pac == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + dtoRequest.getId());
		}

		Cliente p = mapper.map(dtoRequest, Cliente.class);

		Cliente obj = clienteServicio.modificar(p);

		ClienteDto dtoResponse = mapper.map(obj, ClienteDto.class);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	/**
	 * Elimina Cliente por id
	 * 
	 * @param id identificador del Cliente
	 * @return retorna vacio
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception {
		Cliente pac = clienteServicio.listarPorId(id);

		if (pac == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		clienteServicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

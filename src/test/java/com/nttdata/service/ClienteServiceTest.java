/**
 * 
 */
package com.nttdata.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nttdata.enumeration.TipoGeneroEnum;
import com.nttdata.exception.MovimientosException;
import com.nttdata.model.Cliente;
import com.nttdata.repository.IClienteRepo;
import com.nttdata.service.impl.ClienteServicioImpl;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@ExtendWith(MockitoExtension.class)
class ClienteTest {

	@InjectMocks
	ClienteServicioImpl clienteServicio;

	@Mock
	IClienteRepo repo;

	@Test
	void crearClienteTest() throws MovimientosException {
		Cliente cli = new Cliente();

		cli.setIdentificacion("0456645647");
		cli.setContrasenia("123");
		cli.setEstado(true);
		cli.setEdad(20);
		cli.setGenero(TipoGeneroEnum.M);
		cli.setNombre("Gustavo");
		cli.setTelefono("0987656754");
		clienteServicio.registrar(cli);
		verify(repo, timeout(1)).save(cli);
	}

	@Test
	void obenerPorId() {
		Cliente cli = new Cliente();

		cli.setIdentificacion("0456645647");
		cli.setContrasenia("123");
		cli.setEstado(true);
		cli.setEdad(20);
		cli.setGenero(TipoGeneroEnum.M);
		cli.setNombre("Gustavo");
		cli.setTelefono("0987656754");

		when(repo.findById(100L)).thenReturn(Optional.of(cli));

		Optional<Cliente> cliente = repo.findById(100L);

		assertEquals("0456645647", cliente.get().getIdentificacion());
		assertEquals(20, cliente.get().getEdad());
		assertEquals(true, cliente.get().getEstado());
	}

	@Test
	void listarClientes() throws MovimientosException {
		List<Cliente> clientes = new ArrayList<>();
		Cliente cli1 = new Cliente();

		cli1.setIdentificacion("0456645647");
		cli1.setContrasenia("123");
		cli1.setEstado(true);
		cli1.setEdad(20);
		cli1.setGenero(TipoGeneroEnum.M);
		cli1.setNombre("Gustavo");
		cli1.setTelefono("0987656754");
		clientes.add(cli1);
		Cliente cli2 = new Cliente();

		cli2.setIdentificacion("0456645647");
		cli2.setContrasenia("123");
		cli2.setEstado(true);
		cli2.setEdad(20);
		cli2.setGenero(TipoGeneroEnum.M);
		cli2.setNombre("Gustavo");
		cli2.setTelefono("0987656754");
		clientes.add(cli2);
		Cliente cli3 = new Cliente();

		cli3.setIdentificacion("0456645647");
		cli3.setContrasenia("123");
		cli3.setEstado(true);
		cli3.setEdad(20);
		cli3.setGenero(TipoGeneroEnum.M);
		cli3.setNombre("Gustavo");
		cli3.setTelefono("0987656754");
		clientes.add(cli3);

		when(repo.findAll()).thenReturn(clientes);

		List<Cliente> clie = clienteServicio.listar();

		assertEquals(3, clie.size());
		verify(repo, times(1)).findAll();

	}

}

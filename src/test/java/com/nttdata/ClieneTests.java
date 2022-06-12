package com.nttdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nttdata.enumeration.TipoGeneroEnum;
import com.nttdata.exception.MovimientosException;
import com.nttdata.model.Cliente;
import com.nttdata.service.IClienteServicio;

@SpringBootTest
class ClieneTests {

	@Autowired
	IClienteServicio clienteServicio;
	/*
	 * @Test void testCrearCliente() { Cliente cliente = new Cliente();
	 * cliente.setNombre("TestUno"); cliente.setEdad(35);
	 * cliente.setContrasenia("1234"); cliente.setDireccion("Av. de la Republica");
	 * cliente.setEstado(Boolean.TRUE); cliente.setGenero(TipoGeneroEnum.M);
	 * cliente.setIdentificacion("0606654567"); cliente.setTelefono("0987676787");
	 * try { cliente = clienteServicio.registrar(cliente);
	 * assertNotNull(clienteServicio.listarPorId(cliente.getId())); } catch
	 * (MovimientosException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	
	@Test
	 void testListarClientes() {
		try {
			List<Cliente> clientes =clienteServicio.listar();
			assertNotNull(clientes);
			/*assertThat(clientes).size().isNegative();*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

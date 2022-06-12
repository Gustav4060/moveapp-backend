/**
 * 
 */

package com.nttdata.service;

import java.util.List;

import com.nttdata.exception.MovimientosException;

/**
 * @author gustavoefrainparcosanchez
 *
 */
public interface ICRUD<T, ID> {

	T registrar(T t) throws MovimientosException;

	T modificar(T t) throws MovimientosException;

	List<T> listar() throws MovimientosException;

	T listarPorId(ID id) throws MovimientosException;

	void eliminar(ID id) throws MovimientosException;
}

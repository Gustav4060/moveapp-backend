/**
 * 
 */
package com.nttdata.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author gustavoefrainparcosanchez
 *
 */
@NoRepositoryBean
public interface IGenericRepo<T, ID> extends JpaRepository<T, ID> {

}


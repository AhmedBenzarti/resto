package de.tekup.resto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.tekup.resto.Models.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

//	@Query("select id from client c,ticket t "
//			+ "where c.id = t.id_client")
//	List<String> getEmpWithOpt();
}

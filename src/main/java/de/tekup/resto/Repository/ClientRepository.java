package de.tekup.resto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.resto.Models.ClientEntity;


public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

}

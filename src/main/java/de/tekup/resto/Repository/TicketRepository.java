package de.tekup.resto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.resto.Models.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer>{

}

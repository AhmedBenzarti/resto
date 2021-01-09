package de.tekup.resto.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.TicketEntity;
import de.tekup.resto.Repository.TicketRepository;

@Service
public class TicketServiceImpl {

	private final static Logger LOGGER = LoggerFactory.getLogger(TableServiceImpl.class);

	@Autowired
	private TicketRepository ticketRepository;

	public TicketEntity saveClient(TicketEntity table) {
		return ticketRepository.save(table);
	}

	public List<TicketEntity> saveClients(List<TicketEntity> tables) {
		return ticketRepository.saveAll(tables);
	}

	public List<TicketEntity> getAllTickets() {
		return ticketRepository.findAll();
	}

}

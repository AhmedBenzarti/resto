package de.tekup.resto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.ClientEntity;
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

	public Map<String, Long> getClientFaithful() {
		List<TicketEntity> tickets = ticketRepository.findAll();
		Map<String, Long> map2 = new HashMap<>();

		for (TicketEntity ticket : tickets) {
			if (map2.containsKey(ticket.getClient())) {
				LOGGER.info("client : {}", ticket.getClient());
				map2.put(ticket.getClient().getNomClient(), map2.get(ticket.getClient()) + 1);
			} else {
				LOGGER.info("client : {}", ticket.getClient());
				map2.put(ticket.getClient().getNomClient(), 1L);
			}
		}
		LOGGER.info("map : {}", map2);
		return map2;

	}

}

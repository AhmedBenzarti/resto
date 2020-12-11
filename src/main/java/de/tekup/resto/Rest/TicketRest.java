package de.tekup.resto.Rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.Models.TicketEntity;
import de.tekup.resto.service.TicketServiceImpl;

@RestController
public class TicketRest {

	private TicketServiceImpl TicketService;

	@Autowired
	public TicketRest(TicketServiceImpl service) {
		super();
		this.TicketService = service;
	}

	@GetMapping(path = "/api/allTickets")
	public List<TicketEntity> getAll() {
		return TicketService.getAllTickets();
	}
	
	@GetMapping(path = "/api/Faithful")
	public Map<String, Long> getClientFaithful() {
		return TicketService.getClientFaithful();
	}

}

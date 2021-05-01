package de.tekup.resto.Rest;

import java.util.List;

import de.tekup.resto.Models.DTO.TicketReponseDTO;
import de.tekup.resto.Models.DTO.TicketRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.tekup.resto.Models.TicketEntity;
import de.tekup.resto.service.serviceImpl.TicketServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("api/ticket")
public class TicketRest {

	private TicketServiceImpl TicketService;

	@Autowired
	public TicketRest(TicketServiceImpl service) {
		super();
		this.TicketService = service;
	}

	@GetMapping(path = "/allTickets")
	public List<TicketEntity> getAll() {
		return TicketService.getAllTickets();
	}

	@GetMapping("/{numero}")
	public TicketReponseDTO getTicketById(@PathVariable("numero")int numero) {
		return TicketService.getTicketEntityById(numero);
	}

	@PostMapping("/create")
	public TicketReponseDTO createTicket(@Valid @RequestBody TicketRequestDTO ticket) {
		return TicketService.createTicketEntity(ticket);
	}

	@PutMapping("/modify/{numero}")
	public TicketReponseDTO modifyTicket(@PathVariable("numero")int numero, @RequestBody TicketRequestDTO newTicket) {
		return TicketService.modifyTicketEntity(numero, newTicket);
	}

	@DeleteMapping("/delete/{numero}")
	public TicketReponseDTO deleteTicketById(@PathVariable("id")int id) {
		return TicketService.deleteTicketEntityById(id);
	}
	
}

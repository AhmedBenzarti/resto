package de.tekup.resto.Rest;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Models.DTO.ClientDTO;
import de.tekup.resto.Models.DTO.ClientRequestDTO;
import de.tekup.resto.service.ClientServiceImpl;

@RestController
@RequestMapping("api")
public class ClientRest {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ClientRest.class);
	private ClientServiceImpl clientService;

	@Autowired
	public ClientRest(ClientServiceImpl service) {
		super();
		this.clientService = service;
	}

	@GetMapping(path = "/client/getAll")
	public List<ClientEntity> getAll() {
//		LOGGER.info("all clients : {}",clientService.getAllClients().toString());
		return clientService.getAllClients();
	}
	
	@GetMapping(path = "/client/Faithful")
	public Map<String, Long> getClientFaithful() {
//		LOGGER.info("all clients : {}",clientService.getAllClients().toString());
		return clientService.getClientFaithful();
	}
	
	@PostMapping(path = "/client/create")
	public ClientDTO ajouterClient(@Valid @RequestBody ClientRequestDTO client) {
//		LOGGER.info("all clients : {}",clientService.getAllClients().toString());
		return clientService.createClientEntity(client);
	}
	
}

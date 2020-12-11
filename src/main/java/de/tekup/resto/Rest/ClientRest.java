package de.tekup.resto.Rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.Models.ClientEntity;
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

	@GetMapping(path = "/clients")
	public List<ClientEntity> getAll() {
//		LOGGER.info("all clients : {}",clientService.getAllClients().toString());
		return clientService.getAllClients();
	}
	
	@GetMapping(path = "/clientFaithful")
	public Map<String, Long> getClientFaithful() {
//		LOGGER.info("all clients : {}",clientService.getAllClients().toString());
		return clientService.getClientFaithful();
	}
}

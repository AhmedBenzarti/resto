package de.tekup.resto.Rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Models.DTO.ClientResponseDTO;
import de.tekup.resto.Models.DTO.ClientRequestDTO;
import de.tekup.resto.service.serviceImpl.ClientServiceImpl;

@RestController	
@RequestMapping("api")
public class ClientRest {

	private ClientServiceImpl clientService;

	@Autowired
	public ClientRest(ClientServiceImpl service) {
		super();
		this.clientService = service;
	}

	@GetMapping(path = "/client/getAll")
	public List<ClientEntity> getAll() {
		return clientService.getAllClients();
	}

	@PostMapping(path = "/client/create")
	public ClientResponseDTO ajouterClient(@Valid @RequestBody ClientRequestDTO client) {
		return clientService.createClientEntity(client);
	}

}

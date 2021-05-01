package de.tekup.resto.Rest;

import java.util.List;

import javax.validation.Valid;

import de.tekup.resto.Models.DTO.ClientReponseDTO;
import de.tekup.resto.Models.DTO.ClientRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.service.serviceImpl.ClientServiceImpl;

@RestController	
@RequestMapping("api/client")
public class ClientRest {

	private ClientServiceImpl clientService;

	@Autowired
	public ClientRest(ClientServiceImpl service) {
		super();
		this.clientService = service;
	}

	@GetMapping(path = "/getAll")
	public List<ClientEntity> getAll() {
		return clientService.getAllClients();
	}

	@PostMapping(path = "/create")
	public ClientReponseDTO ajouterClient(@Valid @RequestBody ClientRequestDTO client) {
		return clientService.createClientEntity(client);
	}

	@PutMapping("/modify/{id}")
	public ClientReponseDTO modifyClient(@PathVariable("id") int id, @RequestBody ClientRequestDTO newClient) {
		return clientService.modifyClientEntity(id, newClient);
	}

	@DeleteMapping("/delete/{id}")
	public ClientReponseDTO deleteClientById(@PathVariable("id")int id)
	{
		return clientService.deleteClientEntityById(id);
	}

}

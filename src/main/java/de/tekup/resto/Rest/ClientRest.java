package de.tekup.resto.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.service.ClientServiceImpl;

@RestController
public class ClientRest {
	
	private ClientServiceImpl clientService;
	
	@Autowired	
	public ClientRest(ClientServiceImpl service) {
		super();
		this.clientService = service;
	}
//	@PreAuthorize("hasAnyAuthority('USER')")
	@GetMapping(path="/api/clients")
	public List<ClientEntity> getAll(){
		return clientService.getAllClientEntities();
	}
}

package de.tekup.resto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Repository.ClientRepository;

@Service
public class ClientServiceImpl {

    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity saveClient(ClientEntity client){
        return clientRepository.save(client);
    }

    public List<ClientEntity> saveClients(List<ClientEntity> clients){
        return clientRepository.saveAll(clients);
    }
    
	public List<ClientEntity> getAllClientEntities() {
		return clientRepository.findAll();
	}

}

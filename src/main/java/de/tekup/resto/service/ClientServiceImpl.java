package de.tekup.resto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Repository.ClientRepository;

@Service
public class ClientServiceImpl {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private ClientRepository clientRepository;

	public ClientEntity saveClient(ClientEntity client) {
		return clientRepository.save(client);
	}

	public List<ClientEntity> saveClients(List<ClientEntity> clients) {
		return clientRepository.saveAll(clients);
	}

	public List<ClientEntity> getAllClients() {
		return clientRepository.findAll();
	}

	public Map<String, Long> getClientFaithful() {
		List<ClientEntity> clients = clientRepository.findAll();
		Map<String, Long> map2 = new HashMap<>();
		

		for (ClientEntity client : clients) {
			if (map2.containsKey(client.getNomClient())) {
				LOGGER.info("client : {}", client);
				map2.put(client.getNomClient(), map2.get(client.getNomClient()) + 1);
			} else {
				LOGGER.info("client : {}", client);
				map2.put(client.getNomClient(), 1L);
			}
		}
		LOGGER.info("map : {}", map2);
		return map2;
	}

}

package de.tekup.resto.service.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Repository.ClientRepository;

@Service
public class ClientServiceImpl {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	private static final ModelMapper mapper = new ModelMapper();

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



//	// update that consider depatrs
//	public ClientDTO createClientEntity(ClientRequestDTO request) {
//		ClientEntity client = mapper.map(request, ClientEntity.class);
//
//		// save Employee
//		ClientEntity clientInBase = clientRepository.save(client);
//
//		// save ticket
//		List<TicketEntity> tickets = client.getTickets();
//
//		if (tickets != null) {
//			tickets.forEach(ticket -> ticket.setClient(clientInBase));
//			ticketRepository.saveAll(tickets);
//		}
//
//		return mapper.map(clientInBase, ClientDTO.class);
//	}
	

}

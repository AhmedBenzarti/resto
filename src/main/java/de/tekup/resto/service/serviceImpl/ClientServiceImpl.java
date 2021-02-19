package de.tekup.resto.service.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import de.tekup.resto.Models.DTO.ClientReponse;
import de.tekup.resto.Models.DTO.ClientRequest;
import de.tekup.resto.service.ClientService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Models.TicketEntity;
import de.tekup.resto.Repository.ClientRepository;
import de.tekup.resto.Repository.TableRepository;
import de.tekup.resto.Repository.TicketRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	private ClientRepository clientRepository;
	private TicketRepository ticketRepository;
	private ModelMapper mapper;
	
	@Autowired
	public ClientServiceImpl(ClientRepository repos, TicketRepository reposTicket, ModelMapper mapper)
	{
		super();
		this.clientRepository = repos;
		this.ticketRepository = reposTicket;
		this.mapper = mapper;
	}

	@Override
	public ClientEntity saveClient(ClientEntity client) {
		return clientRepository.save(client);
	}

	@Override
	public List<ClientEntity> saveClients(List<ClientEntity> clients) {
		return clientRepository.saveAll(clients);
	}

	@Override
	public List<ClientEntity> getAllClients() {
		return clientRepository.findAll();
	}



//	// update that consider depatrs
//	public ClientResponseDTO createClientEntity(ClientRequestDTO request) {
//		ClientEntity client = mapper.map(request, ClientEntity.class);
//		// save Employee
//		ClientEntity clientInBase = clientRepository.save(client);
//		// save ticket
//		List<TicketEntity> tickets = client.getTickets();
//
//		if (tickets != null) {
//			tickets.forEach(ticket -> ticket.setClient(clientInBase));
//			ticketRepository.saveAll(tickets);
//		}
//
//		return mapper.map(clientInBase, ClientResponseDTO.class);
//	}

	@Override
	public ClientReponse createClientEntity(ClientRequest request) {
		// Mappage entre ClientRequest -> ClientEntity
		ClientEntity entity = mapper.map(request, ClientEntity.class);

		//saving Client
		ClientEntity newEntity = clientRepository.save(entity);

		//saving tickets
		if(entity.getTickets()!=null) {
			for (TicketEntity ticket : entity.getTickets()) {
				ticket.setClient(newEntity);
				ticketRepository.save(ticket);
			}}
		return mapper.map(newEntity, ClientReponse.class);
	}

	@Override
	public ClientReponse modifyClientEntity(int id, ClientRequest newClient) {
		ClientEntity entity = mapper.map(newClient, ClientEntity.class);
		ClientEntity oldEntity = clientRepository.findById(id).get();
		if(newClient.getNom()!=null)
			oldEntity.setNomClient(newClient.getNom());
		if(newClient.getPrenom()!=null)
			oldEntity.setPrenomClient(newClient.getPrenom());
		if(newClient.getDateDeNaissance()!=null)
			oldEntity.setDateDeNaissance(newClient.getDateDeNaissance());
		if(newClient.getCourriel()!=null)
			oldEntity.setCourriel(newClient.getCourriel());
		if(newClient.getTelephone()!=null)
			oldEntity.setTelephone(newClient.getTelephone());
		return mapper.map(clientRepository.save(oldEntity), ClientReponse.class);
	}

	@Override
	public ClientReponse getById(int id) {
		ClientEntity entity = mapper.map(ClientRequest.class, ClientEntity.class);
		Optional<ClientEntity> newEntity = clientRepository.findById(id);
		if(newEntity.isPresent())
			entity = newEntity.get();
		else
			throw new NoSuchElementException("Client with this id is not found");
		ClientReponse client = new ClientReponse(entity.getNomClient(),entity.getPrenomClient(),
				entity.getDateDeNaissance(),entity.getCourriel(),entity.getTelephone(),entity.getAge());
		return mapper.map(client, ClientReponse.class);
	}

	@Override
	public ClientReponse deleteClientEntityById(int id) {
		ClientReponse entity = this.getById(id);
		clientRepository.deleteById(id);
		return entity;
	}
}

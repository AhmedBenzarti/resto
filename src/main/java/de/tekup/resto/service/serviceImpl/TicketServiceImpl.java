package de.tekup.resto.service.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import de.tekup.resto.Models.DTO.TicketReponse;
import de.tekup.resto.Models.DTO.TicketRequest;
import de.tekup.resto.Models.MetEntity;
import de.tekup.resto.Repository.MetRepository;
import de.tekup.resto.service.TicketService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.TicketEntity;
import de.tekup.resto.Repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private final static Logger LOGGER = LoggerFactory.getLogger(TableServiceImpl.class);

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private MetRepository metRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public TicketEntity saveTicket(TicketEntity table) {
		return ticketRepository.save(table);
	}

	@Override
	public List<TicketEntity> saveTickets(List<TicketEntity> tables) {
		return ticketRepository.saveAll(tables);
	}

	@Override
	public List<TicketEntity> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public TicketReponse createTicketEntity(TicketRequest request) {
		// Mappage entre TicketRequest -> TicketEntity
		TicketEntity entity = mapper.map(request, TicketEntity.class);

		//saving Ticket
		TicketEntity newEntity = ticketRepository.save(entity);

		//saving mets
		List<TicketEntity> tickets;
		if(entity.getMets()!=null) {
			for (MetEntity met : entity.getMets()) {
				if (met.getTickets() != null) {
					tickets = met.getTickets();
				}else {
					tickets = new ArrayList<>();
				}
				tickets.add(newEntity);
				met.setTickets(tickets);
				metRepository.save(met);

			}
		}
		return mapper.map(newEntity, TicketReponse.class);
	}

	@Override
	public List<TicketReponse> getAllTicketEntities() {
		List<TicketReponse> listTicketrep = new ArrayList<>();
		List<TicketEntity> listEntity=ticketRepository.findAll();
		for (TicketEntity ticketEntiy : listEntity) {
			listTicketrep.add(mapper.map(ticketEntiy, TicketReponse.class));

		}

		return listTicketrep;
	}


	@Override
	public TicketReponse getTicketEntityById(int numero) {
		TicketEntity entity = mapper.map(TicketRequest.class, TicketEntity.class);
		Optional<TicketEntity> newEntity = ticketRepository.findById(numero);
		if(newEntity.isPresent())
			entity = newEntity.get();
		else
			throw new NoSuchElementException("Ticket with this id is not found");


		TicketReponse ticket = new TicketReponse(entity.getNumeroTicket(),entity.getDate(),entity.getNbCouvert(),
				entity.getAddition());
		return mapper.map(ticket, TicketReponse.class);
	}

	@Override
	public TicketReponse modifyTicketEntity(int numero, TicketRequest newTicket) {


		TicketEntity entity = mapper.map(newTicket, TicketEntity.class);
		TicketEntity oldEntity = ticketRepository.findById(numero).get();
		if(newTicket.getDateTime()!=null)
			oldEntity.setDate(newTicket.getDateTime());
		if(newTicket.getNbCouvert()!=0)
			oldEntity.setNbCouvert(newTicket.getNbCouvert());
		if(newTicket.getAddition()!=0)
			oldEntity.setAddition(newTicket.getAddition());

		return mapper.map(ticketRepository.save(oldEntity), TicketReponse.class);

	}

	@Override
	public TicketReponse deleteTicketEntityById(int id) {
		TicketReponse entity = this.getTicketEntityById(id);
		ticketRepository.deleteById(id);
		return entity;
	}
}

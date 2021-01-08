package de.tekup.resto.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Models.MetEntity;
import de.tekup.resto.Models.TicketEntity;
import de.tekup.resto.Models.DTO.ClientDTO;
import de.tekup.resto.Models.DTO.ClientRequestDTO;
import de.tekup.resto.Repository.ClientRepository;
import de.tekup.resto.Repository.MetRepository;
import de.tekup.resto.Repository.TicketRepository;

@Service
public class ClientServiceImpl {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	private static final ModelMapper mapper = new ModelMapper();

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private MetRepository metRepository;

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
		Map<String, Long> clientFaithful = new HashMap<>();
		clients.stream().forEach(clt -> {
			if (clt.getTickets().size() == clients.stream().mapToInt(emp -> emp.getTickets().size()).max().getAsInt()) {
				clientFaithful.put(clt.getNomClient(),
						(long) clients.stream().mapToInt(emp -> emp.getTickets().size()).max().getAsInt());
			}
		});
		LOGGER.info("clientFaithful : {}", clientFaithful);
		return clientFaithful;
	}

	public List<TicketEntity> getReserveDayPerClient(String nomClient, String prenomClient) {
		List<ClientEntity> clients = clientRepository.findAll();

		List<TicketEntity> ticketClient = new ArrayList<>();
		clients.forEach(clt -> {

			if (clt.getNomClient().equals(nomClient) && clt.getPrenomClient().equals(prenomClient)) {

				ticketClient.addAll(clt.getTickets());

//				LOGGER.info("*********time{}",cal.get(Calendar.DAY_OF_WEEK));
			}
		});
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		for (int i = 0; i < ticketClient.size() - 1; i++) {
			cal.setTime(ticketClient.get(i).getDate());
			cal1.setTime(ticketClient.get(i + 1).getDate());
			if (cal.get(Calendar.DAY_OF_WEEK) == cal1.get(Calendar.DAY_OF_WEEK)) {
				int day = cal.get(Calendar.DAY_OF_WEEK);
				LOGGER.info("le jours est :{}", day);
			}
		}
		LOGGER.info("client : {}", ticketClient);

		return ticketClient;
	}

	public double revenuParMois(String mois) {
		List<TicketEntity> tickets = ticketRepository.findAll();
		double sum = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getDate().toString().substring(5, 7).equals(mois)) {
				sum += tickets.get(i).getAddition();
			}
		}
		return sum / 12;
	}

	public double revenuParSemaine(Date debutSemaine) {
		List<TicketEntity> tickets = ticketRepository.findAll();
		Calendar cal = Calendar.getInstance();
		cal.setTime(debutSemaine);
		cal.add(cal.DATE, 7);
		double sum = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getDate().after(debutSemaine) && tickets.get(i).getDate().before(cal.getTime())) {
				sum += tickets.get(i).getAddition();
			}
		}
		return sum;
	}

	public double revenuParDay(String Day) throws ParseException {
		List<TicketEntity> tickets = ticketRepository.findAll();
		int dayOfWeek = parseDayOfWeek(Day, Locale.FRANCE);
		LOGGER.info("*********{}", dayOfWeek);
		double sum = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getDate().getDay() == dayOfWeek) {
				sum += tickets.get(i).getAddition();
			}
		}
		return sum;
	}

	public double revenuPeriode(Date dateDebut, Date dateFin) {
		List<TicketEntity> tickets = ticketRepository.findAll();
		double sum = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getDate().after(dateDebut) && tickets.get(i).getDate().after(dateFin)) {
				sum += tickets.get(i).getAddition();
			}
		}
		return sum;
	}

	public Map<String, Long> platPlusAcheter(Date dateDebut, Date dateFin) {
		List<MetEntity> mets = metRepository.findAll();
		Map<String, Long> nomPlat = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		LOGGER.info("METS : {}", mets);
		mets.stream().forEach(met -> {

			for (int i = 0; i < met.getTickets().size(); i++) {
				if (met.getTickets().get(i).getDate().after(dateDebut)
						&& met.getTickets().get(i).getDate().before(dateFin)) {
					LOGGER.info("met : {}", met);

					list.add(met.getPlat().getId());
					LOGGER.info("list {}",list);
					if (Collections.frequency(list, met.getPlat().getId()) == met.getPlat().getId()) {
						nomPlat.put("l'id du plat est :", (long) met.getPlat().getId());
					}
				}
			}
		});
		return nomPlat;
	}

	// update that consider depatrs
	public ClientDTO createClientEntity(ClientRequestDTO request) {
		ClientEntity client = mapper.map(request, ClientEntity.class);

		// save Employee
		ClientEntity clientInBase = clientRepository.save(client);

		// save ticket
		List<TicketEntity> tickets = client.getTickets();

		if (tickets != null) {
			tickets.forEach(ticket -> ticket.setClient(clientInBase));
			ticketRepository.saveAll(tickets);
		}

		return mapper.map(clientInBase, ClientDTO.class);
	}

	private static int parseDayOfWeek(String day, Locale locale) throws ParseException {
		SimpleDateFormat dayFormat = new SimpleDateFormat("E", locale);
		java.util.Date date = dayFormat.parse(day);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}

}

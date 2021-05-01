package de.tekup.resto.service.serviceImpl;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Models.MetEntity;
import de.tekup.resto.Models.TableEntity;
import de.tekup.resto.Models.TicketEntity;
import de.tekup.resto.Repository.ClientRepository;
import de.tekup.resto.Repository.MetRepository;
import de.tekup.resto.Repository.TableRepository;
import de.tekup.resto.Repository.TicketRepository;
import de.tekup.resto.service.RestoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestoServiceImpl implements RestoService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private MetRepository metRepository;

	@Autowired
	private TableRepository tableRepository;

	@Override
	public Map<String, Long> clientPlusFidele() {
		List<ClientEntity> clients = clientRepository.findAll();
		Map<String, Long> clientFaithful = new HashMap<>();
		clients.stream().forEach(clt -> {
			if (clt.getTickets().size() == clients.stream().mapToInt(emp -> emp.getTickets().size()).max().getAsInt()) {
				clientFaithful.put(clt.getNomClient(),
						(long) clients.stream().mapToInt(emp -> emp.getTickets().size()).max().getAsInt());
			}
		});
		LOGGER.info("client plus fidele : {}", clientFaithful);
		return clientFaithful;
	}

	@Override
	public List<String> getReserveDayPerClient(String nomClient, String prenomClient) {
		List<ClientEntity> clients = clientRepository.findAll();
		Calendar cal = Calendar.getInstance();
		List<Integer> days = new ArrayList<>();
		List<String> jourPlusReserver = new ArrayList<>();
		List<Integer> dayReserved = new ArrayList<>();
		List<String> dayOfWeek = new ArrayList<String>();
		try {
			clients.forEach(clt -> {
				if (clt.getNomClient().equals(nomClient) && clt.getPrenomClient().equals(prenomClient)) {
					clt.getTickets().stream().forEach(tick -> {
						cal.setTime(tick.getDate());
						days.add(cal.get(Calendar.DAY_OF_WEEK));
						dayReserved.add(days.stream().max(Integer::compare).get());
						for (int j = 0; j < dayReserved.size(); j++) {
							dayOfWeek.add(getDayOfWeek(dayReserved.get(j)));
						}
					});
				}
			});
		} catch (DateTimeParseException e) {
			LOGGER.error(e.getMessage());
		}
		jourPlusReserver.addAll(dayOfWeek.stream().distinct().collect(Collectors.toList()));
		return jourPlusReserver;
	}

	@Override
	public Map<Integer, Long> tablePlusReserve() {
		List<TableEntity> tables = tableRepository.findAll();
		Map<Integer, Long> getMostBookedTable = new HashMap<>();
		tables.stream().forEach(tab -> {
			if (tab.getTickets().size() == tables.stream().mapToInt(emp -> emp.getTickets().size()).max().getAsInt()) {
				getMostBookedTable.put(tab.getNumeroTable(),
						(long) tables.stream().mapToInt(emp -> emp.getTickets().size()).max().getAsInt());
			}
		});
		LOGGER.info("table plus reserve : {}", getMostBookedTable);
		return getMostBookedTable;
	}

	@Override
	public double revenuParSemaine(String debutSemaine) {
		List<TicketEntity> tickets = ticketRepository.findAll();
		java.util.Date dateSem;
		Calendar cal = Calendar.getInstance();
		double sum = 0;

		try {
			dateSem = new SimpleDateFormat("dd-MM-yyyy").parse(debutSemaine);
			cal.setTime(dateSem);
			cal.add(cal.DATE, 7);

			for (int i = 0; i < tickets.size(); i++) {
				if (tickets.get(i).getDate().compareTo(dateSem)
						* cal.getTime().compareTo(tickets.get(i).getDate()) >= 0) {
					sum += tickets.get(i).getAddition();
				}
			}
		} catch (ParseException e) {
			LOGGER.error("Invalid date {}", e.getMessage());
			e.getMessage();
		}
		return sum;
	}

	@Override
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

	@Override
	public double revenuParDay(String Day) {
		List<TicketEntity> tickets = ticketRepository.findAll();
		int dayOfWeek;
		double sum = 0;
		try {
			dayOfWeek = parseDayOfWeek(Day, Locale.FRANCE);
			LOGGER.info("day of week is : {}", dayOfWeek);
			for (int i = 0; i < tickets.size(); i++) {
				if (tickets.get(i).getDate().getDay() == dayOfWeek) {
					sum += tickets.get(i).getAddition();
				}
			}
		} catch (ParseException e) {
			LOGGER.error("le jour est incorrect : {}", e.getMessage());
			e.getMessage();
		}
		return sum;
	}

	@Override
	public double revenuPeriode(String dateDebut, String dateFin) {
		List<TicketEntity> tickets = ticketRepository.findAll();
		java.util.Date dateDeb;
		java.util.Date dateF;
		double sum = 0;
		try {
			dateDeb = new SimpleDateFormat("dd-MM-yyyy").parse(dateDebut);
			dateF = new SimpleDateFormat("dd-MM-yyyy").parse(dateFin);
			for (int i = 0; i < tickets.size(); i++) {
				if (tickets.get(i).getDate().compareTo(dateDeb) * dateF.compareTo(tickets.get(i).getDate()) >= 0) {
					sum += tickets.get(i).getAddition();
				}
			}
		} catch (ParseException e) {
			LOGGER.error("Invalid date :{}", e.getMessage());
			e.getMessage();
		}
		return sum;
	}

	@Override
	public List<Integer> platPlusAcheter(String dateDebut, String dateFin) {
		List<MetEntity> mets = metRepository.findAll();
		List<Integer> nomPlat = new ArrayList<>();
		List<Integer> idsPlat = new ArrayList<>();
		List<Integer> ids = new ArrayList<>();
		java.util.Date dateDeb;
		java.util.Date dateF;

		try {
			dateDeb = new SimpleDateFormat("dd-MM-yyyy").parse(dateDebut);
			dateF = new SimpleDateFormat("dd-MM-yyyy").parse(dateFin);

			mets.stream().forEach(met -> {
				met.getTickets().stream().forEach(tick -> {

					if (tick.getDate().compareTo(dateDeb) * dateF.compareTo(tick.getDate()) >= 0) {
						idsPlat.add(met.getPlat().getId());
						ids.add(idsPlat.stream().max(Integer::compare).get());
					}
				});
			});
		} catch (ParseException e) {
			LOGGER.error("Invalid date :{}", e.getMessage());
			e.getMessage();
		}
		nomPlat.addAll(ids.stream().distinct().collect(Collectors.toList()));
		return nomPlat;
	}

	private static int parseDayOfWeek(String day, Locale locale) throws ParseException {
		SimpleDateFormat dayFormat = new SimpleDateFormat("E", locale);
		java.util.Date date = dayFormat.parse(day);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}

	private static String getDayOfWeek(int value) {
		String day = "";
		switch (value) {
		case 1:
			day = "Sunday";
			break;
		case 2:
			day = "Monday";
			break;
		case 3:
			day = "Tuesday";
			break;
		case 4:
			day = "Wednesday";
			break;
		case 5:
			day = "Thursday";
			break;
		case 6:
			day = "Friday";
			break;
		case 7:
			day = "Saturday";
			break;
		}
		return day;
	}
}

package de.tekup.resto.Rest;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Models.TicketEntity;
import de.tekup.resto.Models.DTO.ClientDTO;
import de.tekup.resto.Models.DTO.ClientRequestDTO;
import de.tekup.resto.service.ClientServiceImpl;

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

	@GetMapping(path = "/met/Faithful")
	public Map<String, List<Integer>> platPlusAcheter(@RequestParam  Date dateDebut, @RequestParam  Date dateFin) {
		return clientService.platPlusAcheter(dateDebut, dateFin);
	}
	
	@GetMapping(path = "/client/Faithful")
	public Map<String, Long> getClientFaithful() {
		return clientService.getClientFaithful();
	}
	
	@GetMapping(path = "/client/ReserveDayPerClient")
	public Map<String, List<String>> getReserveDayPerClient(@RequestParam  String nomClient,@RequestParam  String prenomClient) {
		return clientService.getReserveDayPerClient(nomClient,prenomClient);
	}
	
	@GetMapping(path = "/client/revenu/mois")
	public double revenuParMois(@RequestParam  String mois) {
		return clientService.revenuParMois(mois);
	}
	
	@GetMapping(path = "/client/revenu/jour")
	public double revenuParJour(@RequestParam  String annee) throws ParseException {
		return clientService.revenuParDay(annee);
	}
	
	@GetMapping(path = "/client/revenu/semaines")
	public double revenuParSemaines(@RequestParam  Date debutSemaine) {
		return clientService.revenuParSemaine(debutSemaine);
	}
	
	@GetMapping(path = "/client/revenu/periode")
	public double revenuPeriode(@RequestParam  Date dateDebut, @RequestParam  Date dateFin) {
		return clientService.revenuPeriode(dateDebut,dateFin);
	}

	@PostMapping(path = "/client/create")
	public ClientDTO ajouterClient(@Valid @RequestBody ClientRequestDTO client) {
		return clientService.createClientEntity(client);
	}

}

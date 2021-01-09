package de.tekup.resto.Rest;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.service.RestoServiceImpl;

@RestController	
@RequestMapping("api/resto")
public class RestoRest {
	
	@Autowired
	private RestoServiceImpl restoService;
	
	@GetMapping(path = "/plat/plusAcheter")
	public List<Integer> platPlusAcheter(@RequestParam  String dateDebut, @RequestParam  String dateFin) {
		return restoService.platPlusAcheter(dateDebut, dateFin);
	}
	
	@GetMapping(path = "/client/plusFidele")
	public Map<String, Long> getClientPlusFidele() {
		return restoService.clientPlusFidele();
	}
	
	@GetMapping(path = "/ReserveDayPerClient")
	public Map<String, List<String>> getReserveDayPerClient(@RequestParam  String nomClient,@RequestParam  String prenomClient) {
		return restoService.getReserveDayPerClient(nomClient,prenomClient);
	}
	
//	@GetMapping(path = "/client/fidele")
//	public Map<String, Long> getClientFaithful() {
//		return restoService.getClientFaithful();
//	}
//	
	@GetMapping(path = "/table/plusReserve")
	public Map<Integer, Long> tablePlusReserve() {
		return restoService.tablePlusReserve();
	}
	
	@GetMapping(path = "/revenu/mois")
	public double revenuParMois(@RequestParam  String mois) {
		return restoService.revenuParMois(mois);
	}
	
	@GetMapping(path = "/revenu/jour")
	public double revenuParJour(@RequestParam  String annee) {
		return restoService.revenuParDay(annee);
	}
	
	@GetMapping(path = "/revenu/semaines")
	public double revenuParSemaines(@RequestParam  String debutSemaine) {
		return restoService.revenuParSemaine(debutSemaine);
	}
	
	@GetMapping(path = "/revenu/periode")
	public double revenuPeriode(@RequestParam  String dateDebut, @RequestParam  String dateFin) {
		return restoService.revenuPeriode(dateDebut,dateFin);
	}

}

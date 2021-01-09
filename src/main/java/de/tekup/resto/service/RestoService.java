package de.tekup.resto.service;

import java.util.List;
import java.util.Map;

public interface RestoService {

	public Map<String, Long> clientPlusFidele();

	public List<String> getReserveDayPerClient(String nomClient, String prenomClient);

	public Map<Integer, Long> tablePlusReserve();

	public double revenuParSemaine(String debutSemaine);

	public double revenuParMois(String mois);

	public double revenuParDay(String Day);

	public double revenuPeriode(String dateDebut, String dateFin);

	public List<Integer> platPlusAcheter(String dateDebut, String dateFin);

}

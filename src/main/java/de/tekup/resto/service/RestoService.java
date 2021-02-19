package de.tekup.resto.service;

import java.util.List;
import java.util.Map;

public interface RestoService {

	Map<String, Long> clientPlusFidele();

	List<String> getReserveDayPerClient(String nomClient, String prenomClient);

	Map<Integer, Long> tablePlusReserve();

	double revenuParSemaine(String debutSemaine);

	double revenuParMois(String mois);

	double revenuParDay(String Day);

	double revenuPeriode(String dateDebut, String dateFin);

	List<Integer> platPlusAcheter(String dateDebut, String dateFin);

}

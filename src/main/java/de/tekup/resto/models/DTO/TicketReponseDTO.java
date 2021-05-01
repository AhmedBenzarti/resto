package de.tekup.resto.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketReponseDTO {
	
	private int numero;
	private Date dateTime;
	private int nbCouvert;
	private float addition;
	//private String clientNom;
	
	

}

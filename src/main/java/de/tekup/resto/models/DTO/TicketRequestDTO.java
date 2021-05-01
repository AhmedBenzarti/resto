package de.tekup.resto.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDTO {
	
	//private int numero;
	private Date dateTime;
	private int nbCouvert;
	private float addition;
	private ClientRequestDTO client;
	private TableRequestDTO table;
	private List<MetRequestDTO> mets;

}

package de.tekup.resto.Models.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {

	private String nomClient;

	private String prenomClient;

	private Date dateNaissance;

//	private String courriel;

	private String telephone;
	
//	private String tickets;

}

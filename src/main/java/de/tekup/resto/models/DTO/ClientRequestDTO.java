package de.tekup.resto.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
	
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	private String courriel;
	private String telephone;

}

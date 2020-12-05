package de.tekup.resto.Models;

import java.util.Date;

import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class ClientEntity {

	@Id
	private String nomClient;
	private String prenomClient;
	private Date dateNaissance;
	private String courriel;
	private String telephone;
}

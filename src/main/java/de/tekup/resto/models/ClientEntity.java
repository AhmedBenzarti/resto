package de.tekup.resto.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter@Setter
@Entity	
//@Table(name="client")
public class ClientEntity {

//	@Id
	@Column(name = "nom")
	private String nomClient;
	@Column(name="prenom")
	private String prenomClient;
	@Column(name="dateNais")
	private Date dateNaissance;
	@Column(name="courriel")
	private String courriel;
	@Column(name="telephone")
	private String telephone;
}

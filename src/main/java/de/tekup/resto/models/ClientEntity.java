package de.tekup.resto.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"tickets"})
@Entity
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;

	@Column(name = "nom_client")
	private String nomClient;
	
	@Column(name = "prenom_client")
	private String prenomClient;
	
	@Column(name = "dateNais")
	private Date dateNaissance;
	
	@Column(name = "courriel")
	private String courriel;
	
	@Column(name = "telephone")
	private String telephone;

	@OneToMany(targetEntity = TicketEntity.class, mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<TicketEntity> tickets;
}

package de.tekup.resto.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter@Setter
@Entity	
@Table(name="client")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	
	@Column(name = "nom_client")
	private String nomClient;
	@Column(name="prenom")
	private String prenomClient;
	@Column(name="dateNais")
	private Date dateNaissance;
	@Column(name="courriel")
	private String courriel;
	@Column(name="telephone")
	private String telephone;
	
	@OneToMany(mappedBy = "numero",cascade = CascadeType.REMOVE)
	List<TicketEntity> ticket;
}

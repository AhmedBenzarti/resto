package de.tekup.resto.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class TicketEntity {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTicket")
	private int idTicket;
	@Column(name = "numero_ticket")
	private int numeroTicket;
	@Column(name = "date")
	private Date date;
	@Column(name = "nbcouvert")
	private int nbCouvert;
	@Column(name = "addition")
	private float addition;

	@ManyToOne(targetEntity = TableEntity.class)
	@JoinColumn(name = "numero_table", referencedColumnName = "numero_table", insertable = false, updatable = false)
	@JsonIgnore
	private TableEntity table;

	@ManyToOne(targetEntity = ClientEntity.class)
	@JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable = false, updatable = false)
	@JsonIgnore
	private ClientEntity client;

	@ManyToMany
	@JsonIgnore
	private Collection<MetEntity> mets = new ArrayList<>();
	
}

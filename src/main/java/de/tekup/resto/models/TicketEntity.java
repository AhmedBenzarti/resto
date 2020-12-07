package de.tekup.resto.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="ticket")
public class TicketEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	private int numero;
	@Column(name = "date")
	private Date date;
	@Column(name = "nbcouvert")
	private int nbCouvert;
	@Column(name = "addition")
	private float addition;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "numero_table", nullable = false)
	@JsonIgnore
	private TableEntity table;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	private ClientEntity client;

	@ManyToMany
	@JsonIgnore
	private List<MetEntity> mets;
	
}

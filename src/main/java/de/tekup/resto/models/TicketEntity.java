package de.tekup.resto.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
//@Table(name="ticket")
public class TicketEntity {
	
	@Id
	@Column(name = "numero")
	private int numero;
	@Column(name = "date")
	private Date date;
	@Column(name = "nbcouvert")
	private int nbCouvert;
	@Column(name = "addition")
	private float addition;

//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "num_table", nullable = false)
//	@JsonIgnore
//	private TableEntity table;
//
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JsonIgnore
//	private ClientEntity client;
//
//	@ManyToMany
//	@JsonIgnore
//	private List<MetEntity> mets;
	
}

package de.tekup.resto.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="client")
public class TicketEntity {
	
	@Id
	private int numero;
	private Date date;
	private int nbCouvert;
	private float addition;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "num_table", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private TableEntity table;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "nom_client", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ClientEntity client;
	
}

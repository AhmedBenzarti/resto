package de.tekup.resto.Models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class TableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_table", nullable = false, unique = true)
	private int numeroTable;
	@Column(name = "nb_couvert_table")
	private int nbCouvertTable;
	@Column(name = "type")
	private String type;
	@Column(name = "supplement")
	private float supplement;

	@OneToMany(mappedBy = "numeroTicket")
	private Collection<TicketEntity> tickets = new ArrayList<>();

}

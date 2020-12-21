package de.tekup.resto.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class MetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom")
	private String nom;
	@Column(name = "prix")
	private float prix;

	@ManyToMany(mappedBy = "mets", cascade = CascadeType.REMOVE)
	List<TicketEntity> tickets;

}

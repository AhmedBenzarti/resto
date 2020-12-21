package de.tekup.resto.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "platId")
	private PlatEntity plat;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "dessertId")
	private PlatEntity dessert;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "entreeId")
	private PlatEntity entree;
	
	@ManyToMany(mappedBy = "mets", cascade = CascadeType.REMOVE)
	private List<TicketEntity> tickets;

}

package de.tekup.resto.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"plat","dessert","entree","tickets"})
@Entity
public class MetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prix")
	private float prix;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "platId")
	private PlatEntity plat;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dessertId")
	private DesertEntity dessert;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entreeId")
	private EntreeEntity entree;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<TicketEntity> tickets;

}

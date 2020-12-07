package de.tekup.resto.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
//@Table(name="met")
public class MetEntity{
	
	@Id
	@Column(name = "nom")
	private String nom;
	@Column(name = "prix")
	private float prix;
//
//	@ManyToMany(mappedBy = "mets", cascade = CascadeType.REMOVE)
//	List<TicketEntity> ticket;

}

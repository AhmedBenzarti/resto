package de.tekup.resto.Models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@Entity
@Table(name="met")
public class MetEntity{
	
	@Id
	private String nom;
	private float prix;

	@ManyToMany(mappedBy = "mets", cascade = CascadeType.REMOVE)
	List<TicketEntity> ticket;

}

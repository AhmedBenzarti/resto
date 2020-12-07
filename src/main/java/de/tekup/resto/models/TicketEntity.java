package de.tekup.resto.Models;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
}

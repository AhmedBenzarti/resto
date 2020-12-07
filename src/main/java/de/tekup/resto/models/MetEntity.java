package de.tekup.resto.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="met")
public class MetEntity{
	
	@Id
	private String nom;
	private float prix;

}

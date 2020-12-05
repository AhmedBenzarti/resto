package de.tekup.resto.models;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MetEntity {
	
	@Id
	private String nom;
	private float prix;

}

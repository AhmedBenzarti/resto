package de.tekup.resto.Models;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TableEntity {

	@Id
	private int numeroTable;
	private int nbCouvert;
	private String type;
	private float supplement; 
	
}

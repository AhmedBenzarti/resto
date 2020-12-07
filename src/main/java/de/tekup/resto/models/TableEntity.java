package de.tekup.resto.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="table")
public class TableEntity {

	@Id
	private int numeroTable;
	private int nbCouvert;
	private String type;
	private float supplement; 
	
}

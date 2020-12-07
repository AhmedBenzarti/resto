package de.tekup.resto.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
//@Table(name="table")
public class TableEntity {

	@Id
	@Column(name = "numero_table")
	private int numeroTable;
	@Column(name = "nb_couvert")
	private int nbCouvert;
	@Column(name = "type")
	private String type;
	@Column(name = "supplement")
	private float supplement; 
	
}

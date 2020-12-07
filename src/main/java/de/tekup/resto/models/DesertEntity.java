package de.tekup.resto.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="desert")
public class DesertEntity extends MetEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
}

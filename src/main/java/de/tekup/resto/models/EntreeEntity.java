package de.tekup.resto.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="entree")
public class EntreeEntity extends MetEntity{

}

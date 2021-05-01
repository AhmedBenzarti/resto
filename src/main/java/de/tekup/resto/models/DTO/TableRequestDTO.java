package de.tekup.resto.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableRequestDTO {
	
	
	//private int numero;
	private int nbCouvert;
	private String type;
	private float supplement;

}

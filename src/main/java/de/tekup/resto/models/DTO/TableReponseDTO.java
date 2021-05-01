package de.tekup.resto.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableReponseDTO {
	
	private int nbCouvert;
	private String type;
	private float supplement;

}

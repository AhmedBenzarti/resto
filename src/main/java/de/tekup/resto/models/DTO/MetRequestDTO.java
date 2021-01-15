package de.tekup.resto.Models.DTO;

import java.util.List;

import de.tekup.resto.Models.PlatEntity;
import de.tekup.resto.Models.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetRequestDTO {

	private String nom;

	private float prix;

	private PlatRequestDTO plat;

//	private PlatEntity dessert;
//
//	private PlatEntity entree;

//	private List<TicketEntity> tickets;

}

package de.tekup.resto.Models.DTO;

import de.tekup.resto.Models.DesertEntity;
import de.tekup.resto.Models.EntreeEntity;
import de.tekup.resto.Models.PlatEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetReponseDTO {

	private String nom;
	private float prix;
	private PlatEntity plat;
	private EntreeEntity entree;
	private DesertEntity desert;

	public MetReponseDTO(String nom, float prix) {
	}
}

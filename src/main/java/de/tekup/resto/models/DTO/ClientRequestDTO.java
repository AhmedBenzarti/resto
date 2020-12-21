package de.tekup.resto.Models.DTO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.modelmapper.ModelMapper;

import de.tekup.resto.Models.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {

	private static final ModelMapper mapper = new ModelMapper();

	@NotBlank(message = "Name Requered to have characters")
	@Size(min = 5, max = 50)
	private String nomClient;
	@NotBlank(message = "Name Requered to have characters")
	@Size(min = 5, max = 50)
	private String prenomClient;
	@Past
	private Date dateNaissance;

	private String courriel;

	private String telephone;

	private List<TicketRequestDTO> tickets;

	public List<TicketEntity> getTickets() {
		return tickets.stream().map(d -> mapper.map(d, TicketEntity.class)).collect(Collectors.toList());
	}

}

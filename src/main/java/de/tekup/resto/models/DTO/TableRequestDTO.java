//package de.tekup.resto.Models.DTO;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//
//import de.tekup.resto.Models.TicketEntity;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class TableRequestDTO {
//
//	private static final ModelMapper mapper = new ModelMapper();
//
//	private int numeroTable;
//
//	private int nbCouvertTable;
//
//	private String type;
//
//	private float supplement;
//
//	private List<TicketRequestDTO> tickets;
//
//	public List<TicketEntity> getTickets() {
//		return tickets.stream().map(d -> mapper.map(d, TicketEntity.class)).collect(Collectors.toList());
//	}
//
//}

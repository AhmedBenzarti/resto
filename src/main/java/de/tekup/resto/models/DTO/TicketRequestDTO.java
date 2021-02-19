//package de.tekup.resto.Models.DTO;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//
//import de.tekup.resto.Models.ClientEntity;
//import de.tekup.resto.Models.MetEntity;
//import de.tekup.resto.Models.TableEntity;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class TicketRequestDTO {
//
//	private static final ModelMapper mapper = new ModelMapper();
//
//	private int numeroTicket;
//
//	private Date date;
//
//	private int nbCouvert;
//
//	private float addition;
//
//	private List<TableEntity> table ;
//
//	public List<TableEntity> getTable() {
//		return table.stream().map(d -> mapper.map(d, TableEntity.class)).collect(Collectors.toList());
//	}
//
//	private List<ClientEntity> client ;
//
//	public List<ClientEntity> getClient() {
//		return client.stream().map(d -> mapper.map(d, ClientEntity.class)).collect(Collectors.toList());
//	}
//	private List<MetRequestDTO> mets ;
//
//	public List<MetEntity> getMets() {
//		return mets.stream().map(d -> mapper.map(d, MetEntity.class)).collect(Collectors.toList());
//	}
//
//}

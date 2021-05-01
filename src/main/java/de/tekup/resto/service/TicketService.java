package de.tekup.resto.service;

import de.tekup.resto.Models.DTO.TicketReponseDTO;
import de.tekup.resto.Models.DTO.TicketRequestDTO;
import de.tekup.resto.Models.TicketEntity;

import java.util.List;

public interface TicketService {

    TicketEntity saveTicket(TicketEntity table);

    List<TicketEntity> saveTickets(List<TicketEntity> tables);

    List<TicketEntity> getAllTickets();

    TicketReponseDTO createTicketEntity(TicketRequestDTO request);

    List<TicketReponseDTO> getAllTicketEntities();

    TicketReponseDTO getTicketEntityById(int numero);

    TicketReponseDTO modifyTicketEntity(int numero, TicketRequestDTO newTicket);

    TicketReponseDTO deleteTicketEntityById(int id);
}

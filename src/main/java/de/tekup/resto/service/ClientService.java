package de.tekup.resto.service;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Models.DTO.ClientReponseDTO;
import de.tekup.resto.Models.DTO.ClientRequestDTO;

import java.util.List;

public interface ClientService {

    ClientEntity saveClient(ClientEntity client);

    List<ClientEntity> saveClients(List<ClientEntity> clients);

    List<ClientEntity> getAllClients();

    ClientReponseDTO createClientEntity(ClientRequestDTO request);

    ClientReponseDTO modifyClientEntity(int id, ClientRequestDTO newClient);

    ClientReponseDTO getById(int id);

    ClientReponseDTO deleteClientEntityById(int id);
}

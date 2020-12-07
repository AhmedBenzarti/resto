//package de.tekup.resto.service;
//
//import de.tekup.resto.Models.ClientEntity;
//import de.tekup.resto.Repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class ClientServiceImpl {
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    public ClientEntity saveClient(ClientEntity client){
//        return clientRepository.save(client);
//    }
//
//    public List<ClientEntity> saveClients(List<ClientEntity> clients){
//        return clientRepository.saveAll(clients);
//    }
//}

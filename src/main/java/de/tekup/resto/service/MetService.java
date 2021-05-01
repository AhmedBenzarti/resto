package de.tekup.resto.service;

import de.tekup.resto.Models.DTO.MetReponseDTO;
import de.tekup.resto.Models.DTO.MetRequestDTO;
import de.tekup.resto.Models.MetEntity;

import java.util.List;

public interface MetService {

    MetReponseDTO createMetEntity(MetRequestDTO request);
    List<MetEntity> getAllMetEntities();
    MetReponseDTO getById(String nom);
    MetReponseDTO modifyMetEntity(String nom, MetRequestDTO newMet);
    MetReponseDTO deleteMetEntityById(String nom);
}

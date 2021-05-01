package de.tekup.resto.service;

import de.tekup.resto.Models.DTO.TableReponseDTO;
import de.tekup.resto.Models.DTO.TableRequestDTO;
import de.tekup.resto.Models.TableEntity;

import java.util.List;

public interface TableService {
    List<TableEntity> getAllTables();

    TableReponseDTO createTableEntity(TableRequestDTO request);

    TableReponseDTO getById(int id);

    TableReponseDTO modifyTableEntity(int id, TableRequestDTO newTable);

    TableReponseDTO deleteTableEntityById(int id);
}

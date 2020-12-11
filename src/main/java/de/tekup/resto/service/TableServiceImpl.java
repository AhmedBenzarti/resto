package de.tekup.resto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.TableEntity;
import de.tekup.resto.Repository.TableRepository;

@Service
public class TableServiceImpl {
	
    @Autowired
    private TableRepository tableRepository;

    public TableEntity saveClient(TableEntity table){
        return tableRepository.save(table);
    }

    public List<TableEntity> saveClients(List<TableEntity> tables){
        return tableRepository.saveAll(tables);
    }
    
	public List<TableEntity> getAllTables() {
		return tableRepository.findAll();
	}

}

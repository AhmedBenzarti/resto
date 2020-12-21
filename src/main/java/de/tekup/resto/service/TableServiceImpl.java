package de.tekup.resto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.resto.Models.TableEntity;
import de.tekup.resto.Repository.TableRepository;

@Service
public class TableServiceImpl {

	private TableRepository tableRepository;

	public TableEntity saveTable(TableEntity table) {
		return tableRepository.save(table);
	}

	public List<TableEntity> saveTables(List<TableEntity> tables) {
		return tableRepository.saveAll(tables);
	}

	public List<TableEntity> getAllTables() {
		return tableRepository.findAll();
	}

}

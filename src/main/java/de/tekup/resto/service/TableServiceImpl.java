package de.tekup.resto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.resto.Models.ClientEntity;
import de.tekup.resto.Models.TableEntity;
import de.tekup.resto.Repository.TableRepository;

@Service
public class TableServiceImpl {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	private static final ModelMapper mapper = new ModelMapper();
	
	@Autowired
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
	
	public Map<Integer, Long> tablePlusReserve() {
		List<TableEntity> tables = tableRepository.findAll();
		Map<Integer,Long> getMostBookedTable = new HashMap<>();
		tables.stream().forEach(tab ->{
			if(tab.getTickets().size()==tables.stream().mapToInt(emp -> emp.getTickets().size()).max().getAsInt()) {
				getMostBookedTable.put(tab.getNumeroTable(), (long) tables.stream().mapToInt(emp -> emp.getTickets().size()).max().getAsInt());
			}
		});
		LOGGER.info("clientFaithful : {}",getMostBookedTable);
		return getMostBookedTable;
	}

}

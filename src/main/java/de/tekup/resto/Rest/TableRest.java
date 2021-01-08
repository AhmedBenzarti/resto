package de.tekup.resto.Rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.Models.TableEntity;
import de.tekup.resto.service.TableServiceImpl;

@RestController
@RequestMapping("api")
public class TableRest {

	private TableServiceImpl TableService;

	@Autowired
	public TableRest(TableServiceImpl service) {
		super();
		this.TableService = service;
	}

	@GetMapping(path = "/table/AllTables")
	public List<TableEntity> getAll() {
		return TableService.getAllTables();
	}
	
	@GetMapping(path = "/table/plusReserve")
	public Map<Integer, Long> tablePlusReserve() {
		return TableService.tablePlusReserve();
	}

}

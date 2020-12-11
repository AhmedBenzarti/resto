package de.tekup.resto.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.resto.Models.TableEntity;
import de.tekup.resto.service.TableServiceImpl;

@RestController
public class TableRest {

	private TableServiceImpl TableService;

	@Autowired
	public TableRest(TableServiceImpl service) {
		super();
		this.TableService = service;
	}

	@GetMapping(path = "/api/Tables")
	public List<TableEntity> getAll() {
		return TableService.getAllTables();
	}

}

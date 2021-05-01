package de.tekup.resto.Rest;

import java.util.List;
import java.util.Map;

import de.tekup.resto.Models.DTO.TableReponseDTO;
import de.tekup.resto.Models.DTO.TableRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.tekup.resto.Models.TableEntity;
import de.tekup.resto.service.serviceImpl.TableServiceImpl;

@RestController
@RequestMapping("api/table")
public class TableRest {

	private TableServiceImpl TableService;

	@Autowired
	public TableRest(TableServiceImpl service) {
		super();
		this.TableService = service;
	}

	@GetMapping(path = "/AllTables")
	public List<TableEntity> getAll() {
		return TableService.getAllTables();
	}

	@PostMapping(path = "/AllTables")
	public TableReponseDTO createTable(@RequestBody TableRequestDTO table) {
		return TableService.createTableEntity(table);
	}

	@GetMapping(path = "/{id}")
	public TableReponseDTO getTableById(@PathVariable("id") int id) {
		return TableService.getById(id);

	}

	@PutMapping(path = "/{numero}")
	public TableReponseDTO modifyTable(@PathVariable("numero")int numero,@RequestBody TableRequestDTO newTable)
	{
		return TableService.modifyTableEntity(numero, newTable);
	}

	@DeleteMapping(path = "/{id}")
	public TableReponseDTO deleteTableById(@PathVariable("id")int id)
	{
		return TableService.deleteTableEntityById(id);
	}
}

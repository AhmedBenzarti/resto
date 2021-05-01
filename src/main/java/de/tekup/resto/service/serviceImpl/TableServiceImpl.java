package de.tekup.resto.service.serviceImpl;

import de.tekup.resto.Models.DTO.TableReponseDTO;
import de.tekup.resto.Models.DTO.TableRequestDTO;
import de.tekup.resto.Models.TableEntity;
import de.tekup.resto.Repository.MetRepository;
import de.tekup.resto.Repository.TableRepository;
import de.tekup.resto.Repository.TicketRepository;
import de.tekup.resto.service.TableService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private MetRepository metRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private TableRepository tableRepository;

	@Override
	public List<TableEntity> getAllTables() {
		return tableRepository.findAll();
	}

	@Override
	public TableReponseDTO createTableEntity(TableRequestDTO request) {

		// Mappage entre TicketRequest -> TicketEntity
		TableEntity entity = mapper.map(request, TableEntity.class);

		//saving Table
		TableEntity newEntity = tableRepository.save(entity);
		return mapper.map(newEntity, TableReponseDTO.class);
	}

	@Override
	public TableReponseDTO getById(int id) {
		TableEntity entity;
		Optional<TableEntity> opt = tableRepository.findById(id);
		if(opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("Table with this id is not found");

		TableReponseDTO table = new TableReponseDTO(entity.getNbCouvertTable(), entity.getType(), entity.getSupplement());
		return table;
	}

	@Override
	public TableReponseDTO modifyTableEntity(int id, TableRequestDTO newTable) {
		TableEntity entity = mapper.map(newTable, TableEntity.class);
		TableEntity oldEntity = tableRepository.findById(id).get();
		if(newTable.getNbCouvert()!=0)
			oldEntity.setNbCouvertTable(newTable.getNbCouvert());
		if(newTable.getType()!=null)
			oldEntity.setType(newTable.getType());
		if(newTable.getSupplement()!=0)
			oldEntity.setSupplement(newTable.getSupplement());

		return mapper.map(tableRepository.save(oldEntity), TableReponseDTO.class);
	}

	@Override
	public TableReponseDTO deleteTableEntityById(int id) {
		TableReponseDTO entity = this.getById(id);
		tableRepository.deleteById(id);
		return entity;
	}
}

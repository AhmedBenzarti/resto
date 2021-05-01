package de.tekup.resto.service.serviceImpl;

import de.tekup.resto.Models.DTO.MetReponseDTO;
import de.tekup.resto.Models.DTO.MetRequestDTO;
import de.tekup.resto.Models.MetEntity;
import de.tekup.resto.Repository.MetRepository;
import de.tekup.resto.Repository.TableRepository;
import de.tekup.resto.service.MetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MetServiceImpl  implements MetService {

    @Autowired
    private MetRepository metRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TableRepository tableRepository;

    @Override
    public MetReponseDTO createMetEntity(MetRequestDTO request) {
        // Mappage entre MetRequest -> MetEntity
        MetEntity entity = mapper.map(request, MetEntity.class);
        //saving Met
        MetEntity newEntity = metRepository.save(entity);
        return mapper.map(newEntity, MetReponseDTO.class);

    }

    @Override
    public List<MetEntity> getAllMetEntities() {
        return metRepository.findAll();
    }

    @Override
    public MetReponseDTO getById(String nom) {
        MetEntity entity;
        Optional<MetEntity> opt = metRepository.findById(nom);
        if(opt.isPresent())
            entity = opt.get();
        else
            throw new NoSuchElementException("Table with this id is not found");

        MetReponseDTO met = new MetReponseDTO(entity.getNom(), entity.getPrix());
        return met;
    }

    @Override
    public MetReponseDTO modifyMetEntity(String nom, MetRequestDTO newMet) {
        MetEntity entity = mapper.map(newMet, MetEntity.class);
        MetEntity oldEntity = metRepository.findById(nom).get();
        //if(newMet.getNom()!=null)
        // oldEntity.setNom(newMet.getNom());
        if(newMet.getPlat()!=null)
            oldEntity.setPlat(newMet.getPlat());
        if(newMet.getPrix()!=0)
            oldEntity.setPrix(newMet.getPrix());

        return mapper.map(metRepository.save(oldEntity), MetReponseDTO.class);
    }

    @Override
    public MetReponseDTO deleteMetEntityById(String nom) {
        MetReponseDTO entity = this.getById(nom);
        metRepository.deleteById(nom);
        return entity;
    }


}

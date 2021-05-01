package de.tekup.resto.Rest;

import de.tekup.resto.Models.DTO.MetReponseDTO;
import de.tekup.resto.Models.DTO.MetRequestDTO;
import de.tekup.resto.Models.MetEntity;
import de.tekup.resto.service.MetService;
import de.tekup.resto.service.serviceImpl.MetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/mets"))

public class MetRest {
    @Autowired
    private MetService MetService;

    @Autowired
    public MetRest(de.tekup.resto.service.MetService service)
    {
        super();
        this.MetService = service;
    }

    @PostMapping
    public MetReponseDTO createMet(@RequestBody MetRequestDTO met) {
        return MetService.createMetEntity(met);
    }

    @GetMapping
    public List<MetEntity> getAllMet()
    {
        return MetService.getAllMetEntities();
    }

    @GetMapping("/{nom}")
    public MetReponseDTO getMetById(@PathVariable("nom") String nom)
    {
        return MetService.getById(nom);
    }


    @PutMapping("/{nom}")
    public MetReponseDTO ModifyMet(@PathVariable("nom")String nom,@RequestBody MetRequestDTO newMet)
    {
        return MetService.modifyMetEntity(nom, newMet);
    }


    @DeleteMapping("/{nom}")
    public MetReponseDTO deleteMetById(@PathVariable("nom") String nom)
    {
        return MetService.deleteMetEntityById(nom);
    }

}

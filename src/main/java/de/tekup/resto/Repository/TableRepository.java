package de.tekup.resto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.resto.Models.TableEntity;


public interface TableRepository extends JpaRepository<TableEntity, Integer>{

}

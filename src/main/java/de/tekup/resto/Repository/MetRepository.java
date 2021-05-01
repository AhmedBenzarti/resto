package de.tekup.resto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.resto.Models.MetEntity;

public interface MetRepository extends JpaRepository<MetEntity, String> {

}

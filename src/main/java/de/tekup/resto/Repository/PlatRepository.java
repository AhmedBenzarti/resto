package de.tekup.resto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.resto.Models.PlatEntity;

public interface PlatRepository extends JpaRepository<PlatEntity, Integer>{
}

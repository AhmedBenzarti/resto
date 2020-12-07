package de.tekup.resto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.resto.Models.DesertEntity;

public interface DesertRepository extends JpaRepository<DesertEntity, Integer> {
}

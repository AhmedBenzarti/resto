package de.tekup.resto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.resto.Models.EntreeEntity;

public interface EntreeRepository extends JpaRepository<EntreeEntity, Integer>{
}

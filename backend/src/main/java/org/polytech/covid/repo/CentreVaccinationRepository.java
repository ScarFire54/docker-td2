package org.polytech.covid.repo;

import org.polytech.covid.model.CentreVaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CentreVaccinationRepository extends JpaRepository<CentreVaccination, Integer> {

    Optional<CentreVaccination> findById(Long id);

    @Query(value = "select c from CentreVaccination c where c.name like :search or c.city like :search", nativeQuery = false)
    List<CentreVaccination> searchCenter(@Param("search") String search);
    // %Nancy%Centre%prouvé%

}

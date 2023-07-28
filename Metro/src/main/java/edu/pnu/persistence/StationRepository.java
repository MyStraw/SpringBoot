package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Station;

public interface StationRepository extends JpaRepository<Station, String> {

}

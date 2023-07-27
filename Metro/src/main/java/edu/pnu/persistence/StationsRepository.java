package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Stations;

public interface StationsRepository extends JpaRepository<Stations, String> {

}

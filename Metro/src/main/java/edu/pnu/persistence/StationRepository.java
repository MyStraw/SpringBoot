package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Station;

public interface StationRepository extends JpaRepository<Station, Long> {
	@Query("쿼리문")
	List<Station> getStation();

}

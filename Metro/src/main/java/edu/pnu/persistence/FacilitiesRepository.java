package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Facilities;

public interface FacilitiesRepository extends JpaRepository<Facilities, String> {

}

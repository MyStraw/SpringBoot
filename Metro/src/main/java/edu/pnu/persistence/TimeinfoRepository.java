package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Timeinfo;

public interface TimeinfoRepository extends JpaRepository<Timeinfo, String> {
 

}

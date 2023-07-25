package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Total;

public interface TotalRepository extends JpaRepository<Total, String> {

}

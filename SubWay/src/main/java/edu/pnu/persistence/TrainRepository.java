package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Train;

public interface TrainRepository extends JpaRepository<Train, String> {

}

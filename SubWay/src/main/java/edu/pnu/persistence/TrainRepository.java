package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Train;

public interface TrainRepository extends JpaRepository<Train, String> {

	List<Train> findByTrainNoAndStart(Long trainNo, String start);

}

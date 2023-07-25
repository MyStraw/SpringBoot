package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Station_arrive;
import edu.pnu.domain.Total;
import edu.pnu.domain.Train;
import edu.pnu.persistence.Station_arriveRepository;
import edu.pnu.persistence.TotalRepository;
import edu.pnu.persistence.TrainRepository;

@RestController
public class SubwayController {
	
	//private SubwayService subwayService;
	@Autowired
	TotalRepository totalRepo;
	
	@Autowired
	Station_arriveRepository stationRepo;
	
	@Autowired
	TrainRepository trainRepo;
	
	@GetMapping("/total")
	public List<Total> getTotal() {
		return totalRepo.findAll();
	}
	
	@GetMapping("/station")
	public List<Station_arrive> getStation() {
		return stationRepo.findAll();
	}

	@GetMapping("/train")
	public List<Train> getTrain() {
		return trainRepo.findAll();
	}

}

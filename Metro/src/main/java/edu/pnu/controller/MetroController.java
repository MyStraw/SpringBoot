package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Facilities;
import edu.pnu.domain.Startend;
import edu.pnu.domain.Stations;
import edu.pnu.domain.Times;
import edu.pnu.persistence.FacilitiesRepository;
import edu.pnu.persistence.StartendRepository;
import edu.pnu.persistence.StationsRepository;
import edu.pnu.persistence.TimesRepository;

@RestController
public class MetroController {
	
	@Autowired
	StationsRepository stationsRepo;
	
	@Autowired
	FacilitiesRepository facilitiesRepo;	
	
	@Autowired
	StartendRepository startendRepo;
	
	@Autowired
	TimesRepository timesRepo;	

	
	
	@GetMapping("/stations")
	public List<Stations> getStations() {
		return stationsRepo.findAll();
	}
	
	@GetMapping("/facilities")
	public List<Facilities> getFacilities() {
		return facilitiesRepo.findAll();
	}

	@GetMapping("/startend")
	public List<Startend> getStartend() {
		return startendRepo.findAll();
	}
	
	@GetMapping("/times")
	public List<Times> getTimes() {
		return timesRepo.findAll();
	}
	
	
//	@GetMapping("/train/{trainNo}/{start}")
//	public List<Train> getTrainByTrainNo(@PathVariable Long trainNo, @PathVariable String start) {
//	    return trainRepo.findByTrainNoAndStart(trainNo,start);
//	}
	

}
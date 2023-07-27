package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Station;

@RestController
public class MetroController {
	
	@GetMapping("/total")
	public List<Station> getStation() {
		return totalRepo.findAll();
	}

}

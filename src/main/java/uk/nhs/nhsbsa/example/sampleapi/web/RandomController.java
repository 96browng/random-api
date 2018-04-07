package uk.nhs.nhsbsa.example.sampleapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.nhs.nhsbsa.example.sampleapi.service.RandomService;

@RestController
public class RandomController {

	private RandomService service;
	
	@Autowired
	public RandomController(RandomService randomService) {
		this.service = randomService;
	}
	
	@GetMapping("/")
	public ResponseEntity<String> random() {
		String msg = String.format("Next random: %d", service.getNextRandom());
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}

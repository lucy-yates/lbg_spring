package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Pikmin;
import com.lbg.demo.services.PikminService;

@RestController
@RequestMapping("/pikmin")
public class PikminController {

	private PikminService service;

	public PikminController(PikminService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Pikmin> createPikmins(@RequestBody Pikmin newPikmins) {
		return this.service.createPikmin(newPikmins);
	}

	@GetMapping("/get")
	public List<Pikmin> getPikmin() {
		return this.service.getPikmins();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Pikmin> getPikmin(@PathVariable int id) {
		return this.service.getPikmin(id);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Pikmin> updatePikmin(@PathVariable int id, @RequestBody Pikmin newPikmin) {
		return this.service.updatePikmin(id, newPikmin);
	}

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);
	}
}

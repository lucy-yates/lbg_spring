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

import com.lbg.demo.domain.Captain;
import com.lbg.demo.services.CaptainService;

@RestController
@RequestMapping("/captain")
public class CaptainController {
	private CaptainService service;

	public CaptainController(CaptainService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Captain> createCaptains(@RequestBody Captain newCaptains) {
		return this.service.createCaptain(newCaptains);
	}

	@GetMapping("/get")
	public List<Captain> getCaptain() {
		return this.service.getCaptains();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Captain> getCaptain(@PathVariable int id) {
		return this.service.getCaptain(id);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Captain> updateCaptain(@PathVariable int id, @RequestBody Captain newCaptain) {
		return this.service.updateCaptain(id, newCaptain);
	}

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);
	}
}

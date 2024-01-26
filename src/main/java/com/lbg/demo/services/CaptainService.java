package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Captain;
import com.lbg.demo.repo.CaptainRepo;

@Service
public class CaptainService {
	private CaptainRepo repo;

	public CaptainService(CaptainRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Captain> createCaptain(Captain newCaptain) {
		Captain created = this.repo.save(newCaptain);
		return new ResponseEntity<Captain>(created, HttpStatus.CREATED);

	}

	public List<Captain> getCaptains() {
		return this.repo.findAll();
	}

	public ResponseEntity<Captain> getCaptain(int id) {
		Optional<Captain> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Captain>(HttpStatus.NOT_FOUND);
		}

		Captain body = found.get();

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Captain> updateCaptain(int id, Captain newCaptain) {
		Optional<Captain> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Captain>(HttpStatus.NOT_FOUND);
		}

		Captain existing = found.get();

		if (newCaptain.getName() != null) {
			existing.setName(newCaptain.getName());
		}

		if (newCaptain.getPlanet() != null) {
			existing.setPlanet(newCaptain.getPlanet());
		}

		Captain updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

}

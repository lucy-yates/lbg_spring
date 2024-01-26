package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Pikmin;
import com.lbg.demo.repo.PikminRepo;

@Service
public class PikminService {
	private PikminRepo repo;

	public PikminService(PikminRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Pikmin> createPikmin(Pikmin newPikmin) {
		Pikmin created = this.repo.save(newPikmin);
		return new ResponseEntity<Pikmin>(created, HttpStatus.CREATED);

	}

	public List<Pikmin> getPikmins() {
		return this.repo.findAll();
	}

	public ResponseEntity<Pikmin> getPikmin(int id) {
		Optional<Pikmin> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Pikmin>(HttpStatus.NOT_FOUND);
		}

		Pikmin body = found.get();

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Pikmin> updatePikmin(int id, Pikmin newPikmin) {
		Optional<Pikmin> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Pikmin>(HttpStatus.NOT_FOUND);
		}

		Pikmin existing = found.get();

		if (newPikmin.getColour() != null) {
			existing.setColour(newPikmin.getColour());
		}

		if (newPikmin.getPower() != null) {
			existing.setPower(newPikmin.getPower());
		}

		Pikmin updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

}

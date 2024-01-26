//package com.lbg.demo.services;

//import java.util.ArrayList;
//import java.util.List;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;

//import com.lbg.demo.domain.Pikmin;

//@Service
//public class PikminServiceOld {
//
// private List<Pikmin> pikmins = new ArrayList<>();
//
// public ResponseEntity<Pikmin> createPikmin(Pikmin newPikmin) {
// this.pikmins.add(newPikmin);
// returns the last element in the list
// Pikmin body = this.pikmins.get(this.pikmins.size() - 1);
//
// return new ResponseEntity<Pikmin>(body, HttpStatus.CREATED);
// }
//
// public List<Pikmin> getPikmins() {
// return pikmins;
// }

//	public ResponseEntity<Pikmin> getPikmin(int id) {
//		if (id < 0 || id >= this.pikmins.size()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		Pikmin found = this.pikmins.get(id);

//		return ResponseEntity.ok(found);
//	}

//	public Pikmin updatePikmin(int id, Pikmin newPikmin) {
//		return this.pikmins.set(id, newPikmin);
//	}

//	public Pikmin remove(int id) {
//		return this.pikmins.remove(id);
//	}
//}

package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lbg.demo.domain.Pikmin;

public class PikminController {

	private List<Pikmin> pikmins = new ArrayList<>();

	@PostMapping("/create")
	public String createPikmin(@RequestBody Pikmin newPikmin) {
		this.pikmins.add(newPikmin);
		return pikmins.toString();
	}

}

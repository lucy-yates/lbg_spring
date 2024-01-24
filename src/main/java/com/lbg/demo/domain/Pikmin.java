package com.lbg.demo.domain;

public class Pikmin {

	private String colour;
	private String power;

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getPowers() {
		return powers;
	}

	public void setPower(String powers) {
		this.powers = powers;
	}

	@Override
	public String toString() {
		return "Pikmin [colour=" + colour + ", powers=" + powers + "]";
	}

}

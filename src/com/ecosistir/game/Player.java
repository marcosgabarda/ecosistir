package com.ecosistir.game;

public class Player 
{
	private String name = "";
	
	private double score;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}
}

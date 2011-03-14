package com.ecosistir.board;

public class Desert extends Zone 
{
	public Desert(String name, String patternName, double markerWidth,
			double[] markerCenter) 
	{
		super(name, patternName, markerWidth, markerCenter);
		setMovement(0);
		setFood(0);
	}
}

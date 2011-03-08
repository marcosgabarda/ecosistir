package com.ecosistir.animals;

public class Abrelatas extends Animal
{
	private Abrelatas(String name, String patternName, double markerWidth,
			double[] markerCenter)
	{
		super(name, patternName, markerWidth, markerCenter);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Get a instance of Abrelatas.
	 * @return Abrelatas
	 */
	public static Abrelatas getInstance()
	{
		String name = "";
		String patternName = ""; 
		double markerWidth = 0.0;
		double[] markerCenter = {0.0};
		return new Abrelatas(name, patternName, markerWidth, markerCenter);
	}
	
}

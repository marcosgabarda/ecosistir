package com.ecosistir.board;

public class Sea extends Zone
{
	public Sea(String name, String patternName, double markerWidth,
			double[] markerCenter) 
	{
		super(name, patternName, markerWidth, markerCenter);
		// TODO Auto-generated constructor stub
	}
	public static Sea getInstance()
	{
		String name = "";
		String patternName = ""; 
		double markerWidth = 0.0;
		double[] markerCenter = {0.0};
		return new Sea(name, patternName, markerWidth, markerCenter);
	}
}

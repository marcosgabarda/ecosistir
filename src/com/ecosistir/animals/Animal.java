package com.ecosistir.animals;

import javax.microedition.khronos.opengles.GL10;

import edu.dhbw.andar.ARObject;

public abstract class Animal extends ARObject
{
	public Animal(String name, String patternName, double markerWidth,
			double[] markerCenter)
	{
		super(name, patternName, markerWidth, markerCenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GL10 arg0)
	{
		// TODO
	}
}

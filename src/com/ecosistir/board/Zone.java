package com.ecosistir.board;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import edu.dhbw.andar.ARObject;

/**
 * Una
 * @author Marcos Gabarda
 *
 */
public abstract class Zone extends ARObject
{
	private int x_size = 5;

	private int y_size = 5;

	private int food;

	private int movement;

	private ArrayList<Square> squares;

	public Zone(String name, String patternName, double markerWidth,
			double[] markerCenter)
	{
		super(name, patternName, markerWidth, markerCenter);
		squares = new ArrayList<Square>();
		for (int i = 0; i < x_size; i++)
		{
			for (int j = 0; j < y_size; j++)
			{
				squares.add(new Square(this, i, j));
			}
		}
	}

	@Override
	public void init(GL10 arg0)
	{
		// TODO Auto-generated method stub

	}

	public void setMovement(int movement)
	{
		this.movement = movement;
	}

	public int getMovement()
	{
		return movement;
	}

	public void setFood(int food)
	{
		this.food = food;
	}

	public int getFood()
	{
		return food;
	}

}

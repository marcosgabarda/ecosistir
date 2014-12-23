package com.ecosistir.board;

/**
 *
 * @author Marcos Gabarda
 *
 */
public class Square
{
	private Zone zone;

	private int x;

	private int y;

	public Square (Zone parent, int x, int y)
	{
		this.setX(x);
		this.setY(y);
		this.zone = parent;
	}

	public Zone getZone()
	{
		return zone;
	}


	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	private void setX(int x)
	{
		this.x = x;
	}

	private void setY(int y)
	{
		this.y = y;
	}
}

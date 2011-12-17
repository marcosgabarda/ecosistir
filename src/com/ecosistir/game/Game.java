package com.ecosistir.game;

import java.util.ArrayList;

import com.ecosistir.board.Sea;
import com.ecosistir.board.Zone;

public final class Game
{
	private int rounds;

	private int current_round;
	private int current_player;

	private ArrayList<Player> players;

	private int numPlayers;

	private ArrayList<Zone> board;

	static private Game game = null;

	private void buildBoard()
	{
		board = new ArrayList<Zone>();
		board.add(Sea.getInstance());
	}

	private Game()
	{
		players = new ArrayList<Player>();
		current_round = 0;
		current_player = 0;
	}

	private Game(int rounds, ArrayList<Player> players)
	{
		this.rounds = rounds;
		this.players = players;
		current_round = 0;
		current_player = 0;
		buildBoard();
	}

	static public Game getGame()
	{
		return game;
	}

	static public Game newGame()
	{
		game = new Game();
		return game;
	}

	public void setDuration(int rounds)
	{
		this.rounds = rounds;
	}

	public int getDuration()
	{
		return rounds;
	}

	public void setNumPlayers(int numPlayers)
	{
		this.numPlayers = numPlayers;
	}

	public int getNumPlayers()
	{
		return numPlayers;
	}

	public void addPlayer(Player player)
	{
		players.add(player);
	}

	public ArrayList<Player> getPlayers()
	{
		return players;
	}

	public void run()
	{
		for (int round = 0; round < rounds; round++)
		{
			System.out.println("Round: " + round);
			for (Player player : players)
			{
				/**
				 * Turn.
				 */
				System.out.println("Player: " + player.getName());
			}
		}
	}

	public int getCurrentRound()
	{
		return current_round;
	}

	public Player getCurrentPlayer()
	{
		return players.get(current_player);
	}

	/**
	 * Run test game.
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		Game game = new Game(Duration.LONG, players);
		game.run();
	}

}

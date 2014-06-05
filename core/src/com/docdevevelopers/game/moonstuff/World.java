package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.math.Vector2;

public class World 
{
	//For future implementation. Would replace updateShip() method.
	public interface WorldListener
	{
		
	}
	
	public int state = 0;
	public int score = 0;
	public static final float WORLD_WIDTH = 320;
	public static final float WORLD_HEIGHT = 480;
	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_NEXT_LEVEL = 1;
	public static final int WORLD_STATE_GAME_OVER = 2;
	public static final Vector2 gravity = new Vector2(0, -9);
	public SpaceShip ship;
	public Platform platform;
	public final WorldListener listener;


	
	
	public World(WorldListener listener)
	{
		this.listener = listener;
		generateLevel();

	}
	
	//Make all game objects
	public void generateLevel()
	{
		ship = new SpaceShip(320/2,World.this);
		platform = new Platform(3);	
	}
	
	//Update any object. Gets called on every refresh of renderer in GameScreen.
	public void update(float deltaTime, float f,boolean up)
	{
		updateShip(f,up);
		
	}
	
	private void checkCollisions(int x) 
	{
		
		if (x==2)
		{
			state = 2;
			
		}
		else if(ship.fuel == 0)
		{
			state = 3;
		}
		
	}

	private void updateShip(float f,boolean up)
	{
		
		boolean x = up;
		//thrusters on
		if(x)
			state=1;
		//thrusters off
		if(x==false)
			state=0;
		int crash = ship.update(f,x);
		checkCollisions(crash);
	}

	
	

}

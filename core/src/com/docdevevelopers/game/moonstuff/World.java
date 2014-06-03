package com.docdevevelopers.game.moonstuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class World 
{
	public interface WorldListener
	{
		public void slideLeft();
		
		public void slideRight();
		
		public void hit();
	}
	
	public static final float WORLD_WIDTH = 320;
	public static final float WORLD_HEIGHT = 480;
	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_NEXT_LEVEL = 1;
	public static final int WORLD_STATE_GAME_OVER = 2;
	public static final Vector2 gravity = new Vector2(0, -9);
	
	public final List<Asteroid> smallAsteroids;
	public SpaceShip ship;
	public Platform platform;
	public final WorldListener listener;
	public final Random rand;

	
	
	public World(WorldListener listener)
	{
		this.smallAsteroids = new ArrayList<Asteroid>();
		this.listener = listener;
		rand = new Random();
		generateLevel();

	}
	
	public void generateLevel()
	{
		ship = new SpaceShip(320/2);
		platform = new Platform(100, 100, 50);	
	}
	
	public void update(float deltaTime, float f)
	{
		checkCollisions();
		updateShip(f);
		
	}
	
	private void checkCollisions() 
	{
		
		if (Intersector.overlaps(platform.bounds,ship.bounds))
		{
			GameScreen.setScreen();
		}
		
			
		
		
	}

	private void updateShip(float f) {
		ship.update(f);
		
	}

	public void updateAsteroids(float deltaTime)
	{
		int len = smallAsteroids.size();
		for (int i = 0; i < len; i++) 
		{
			Asteroid asteroid = smallAsteroids.get(i);
		
			asteroid.update(deltaTime);
			
		}
	}
	

}

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
	public int state = 0;
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
		ship = new SpaceShip(320/2);
		platform = new Platform(100, 100);	
	}
	
	public void update(float deltaTime, float f,boolean up)
	{
		checkCollisions();
		updateShip(f,up);
		
	}
	
	private void checkCollisions() 
	{
		
		if (Intersector.overlaps(platform.bounds,ship.bounds))
		{
			state = 2;
			
		}
		
			
		
		
	}

	private void updateShip(float f,boolean up) {
		ship.update(f,up);
		if(up)
			state=1;
		if(up==false)
			state=0;
		checkCollisions();
		
		
			
		
	}

	
	

}

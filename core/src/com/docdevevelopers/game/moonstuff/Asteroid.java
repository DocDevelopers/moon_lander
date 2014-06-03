package com.docdevevelopers.game.moonstuff;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Asteroid extends DynamicCircleGameObject {
	public static float ASTEROID_WIDTH = 64 ;
	public static float ASTEROID_HEIGHT = 64;
	public static final int ASTEROID_TYPE_STATIC = 0;
	public static final int ASTEROID_TYPE_MOVING = 1;
	public static final int ASTEROID_VELOCITY = 2;
	public TextureRegion texture;
	
	
	int type;
	int state;
	float stateTime;
	Random rand = new Random();
	
	public Asteroid(float x, float y) 
	{
		super(x, y, ASTEROID_WIDTH, ASTEROID_HEIGHT);
		velocity.set(World.gravity.x * 0.1f, World.gravity.y * 0.1f);
		randomTexture();
		
	}
	
	public void update (float deltaTime) 
	{
		position.add(velocity.x * 0.9f, velocity.y * 0.9f);
		bounds.x = position.x;
		bounds.y = position.y;

		if(texture  == Assets.smallAsteroid && position.y < -64) 
		{
			randomTexture();
			position.y = rand.nextInt(1000-500)+500;
			position.x = rand.nextInt(320);
			
		}
		if(texture  == Assets.mediumAsteroid && position.y < -128) 
		{
			randomTexture();
			position.y = rand.nextInt(1000-500)+500;
			position.x = rand.nextInt(320);
			
		}
		if(texture  == Assets.largeAsteroid && position.y < -256) 
		{
			randomTexture();
			position.y = rand.nextInt(1000-500)+500;
			position.x = rand.nextInt(320);
			
		}
		if (position.x > World.WORLD_WIDTH || position.x < 0) position.x = World.WORLD_WIDTH ;
	}
	
	private void randomTexture()
	{
		Random rand = new Random();
		int randNum = rand.nextInt(3 - 1 + 1) + 1;
		if(randNum == 1) 
		{
			texture = Assets.smallAsteroid;
			ASTEROID_WIDTH = 52;
			ASTEROID_HEIGHT = 46;
		}
		
		else if(randNum == 2) 
		{
			texture = Assets.mediumAsteroid;
			ASTEROID_WIDTH = 108;
			ASTEROID_HEIGHT = 96;
		}
		else if(randNum == 3) 
		{
			texture = Assets.largeAsteroid;
			ASTEROID_WIDTH = 155;
			ASTEROID_HEIGHT = 165;
		}
			
		else
		{
			texture = Assets.largeAsteroid;
		}
		
	}
	
	

}

package com.docdevevelopers.game.moonstuff;

public class SpaceShip extends DynamicRectangleGameObject 
{
	public World world;
	public double fuel = 100.00;
	public int state;
	public SpaceShip(float x,World world) 
	{
		super(x, 480, 39, 59);
		this.world = world;
		velocity.set(World.gravity.x * 0.1f, World.gravity.y * 0.1f);
		// TODO Auto-generated constructor stub
	}
	
	public int update(float f,boolean up) 
	{
		//Gravity stuff
		position.add(f, velocity.y * 0.9f);
		bounds.x = position.x;
		bounds.y = position.y;

		//Make sure it doesn't leave the window
		if(position.x <= 0)
			position.x = 0;
		
		else if(position.x >= 320-this.bounds.width)
			position.x=320-this.bounds.width;
		
		//Lands on platform
		if(this.position.x >= world.platform.position.x - this.bounds.width && this.position.x <= world.platform.position.x + world.platform.bounds.width && position.y <= 100)
		{
			position.y = 100;
			return 2;
		}
		else if(this.position.y <= 70)
		{
			position.y = 70;
			return 2;
		}
		
		//Check if you have fuel before moving
		if(up && fuel > 0)
		{
			position.add(f, velocity.y * -2f);
			
		}
		else
		{
			position.add(f, velocity.y * 0.1622f);
		}
		
		//Make sure fuel doesn't go negative
		if(fuel!=0)
		fuel -= .005;
		
		return 1;
		}
	
	
	

}

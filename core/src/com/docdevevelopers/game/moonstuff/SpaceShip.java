package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.utils.Logger;

public class SpaceShip extends DynamicRectangleGameObject 
{

	public SpaceShip(float x) 
	{
		super(x, 480, 39, 59);
		velocity.set(World.gravity.x * 0.1f, World.gravity.y * 0.1f);
		// TODO Auto-generated constructor stub
	}
	
	public void slide()
	{
		
	}

	public void update(float f) 
	{
		//bounds.x = position.x - bounds.width / 2;
		//bounds.y = position.y - bounds.height / 2;
		
		position.add(f, velocity.y * 0.9f);
		bounds.x = position.x;
		bounds.y = position.y;

		
			//position.x = (float) (f/3.746875-77/2);
		
		new Logger("logger").error( Float.toString(f));
		position.x = (int) position.x+f;
		if(position.x <= 0)
			position.x = 0;
		
		else if(position.x >= 243)
			position.x=243;
		
		
		
			
		
	}

}

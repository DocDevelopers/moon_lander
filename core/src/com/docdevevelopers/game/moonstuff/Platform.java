package com.docdevevelopers.game.moonstuff;

public class Platform extends RectangleGameObject {

	public Platform(int diff) {
		super(0, 100, 0, 25);
		chgLoc(2);
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	//random placement of the platform
	private float xPos()
	{
		float pX= (float)( Math.random() * 200)+1;
		
		return pX;
		
	
	}
	//difficulty algorithm. Not really that sophisticated.
	private float width(int diff)
	{
		float result = 0;
		if (diff==1)
		{
			result= 300;
		}
		else if (diff==2)
		{
			result= 150;
		}	
		else if (diff==1)
		{
			result= 75;
		}
		
		return result;
	}	

	//Call when you wanna generate new level
	public void chgLoc(int diff)
	{
		position.x = xPos();
		bounds.width = width(diff);
	}

}


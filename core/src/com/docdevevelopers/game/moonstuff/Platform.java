package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;

public class Platform extends RectangleGameObject {

	public Platform(int diff) {
		super(50, 100, 50, 50);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	private static float xPos()
	{
		float pX= (float)( Math.random() * 200)+1;
		
		return pX;
		
	
	}
	private static float width(int diff)
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


	public void  chgLoc(int diff)
	{
		this.position.x = width(diff);
		this.bounds.x = xPos();


	}

}


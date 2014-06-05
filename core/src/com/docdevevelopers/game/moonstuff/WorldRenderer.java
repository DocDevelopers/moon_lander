 package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WorldRenderer 
{
	World world;
	OrthographicCamera cam;
	SpriteBatch batch;
	ShapeRenderer shapes;
	TextureRegion background;

	public WorldRenderer (SpriteBatch batch, World world) 
	{
		this.world = world;
		this.cam = new OrthographicCamera(320, 480);
		//put camera in the middle of the screen.
		this.cam.position.set(320 / 2, 480 / 2, 0);
		this.batch = batch;
		this.shapes = new ShapeRenderer();
	}

	public void render () 
	{
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		shapes.setProjectionMatrix(cam.combined);
		renderBackground();
		renderObjects();
	}

	public void renderBackground () 
	{
		batch.disableBlending();
		batch.begin();
		batch.draw(Assets.backgroundRegion,0,0,320,480);
		batch.end();
	}

	public void renderObjects () {
		
		batch.enableBlending();
		batch.begin();
		//Text display
		BitmapFont font = new BitmapFont();
		font.setColor(0f, 1.0f, 0f, 1.0f);
		CharSequence str = "";
		
		//different ship states
		if(world.state == 0)
		{
			world.score++;
			batch.draw(Assets.TRegion, world.ship.position.x, world.ship.position.y, Assets.TRegion.getRegionWidth(), Assets.TRegion.getRegionHeight());
			str = "Fuel:"+Math.floor(world.ship.fuel)+" Prepare for impact!  Score:"+world.score;
		}
		else if(world.state == 1)
		{
			world.score++;
			batch.draw(Assets.shipRegion, world.ship.position.x, world.ship.position.y, Assets.shipRegion.getRegionWidth(), Assets.shipRegion.getRegionHeight());
			str = "Fuel:"+Math.floor(world.ship.fuel)+" Prepare for impact!  Score:"+world.score;
		}
		else if(world.state == 2)
		{
			batch.draw(Assets.CRegion, world.ship.position.x, world.ship.position.y, Assets.CRegion.getRegionWidth(), Assets.CRegion.getRegionHeight());
			font.setColor(1.0f, 0f, 0f, 1.0f);
			str = "Fuel:"+Math.floor(world.ship.fuel)+"  The whole crew is dead!  Score:"+world.score;
		}
		else if(world.state == 3)
		{
			str = "Fuel:"+Math.floor(world.ship.fuel)+"  You ran out of fuel!  Score:"+world.score;
			batch.draw(Assets.TRegion, world.ship.position.x, world.ship.position.y, Assets.TRegion.getRegionWidth(), Assets.TRegion.getRegionHeight());
			
		}
		 
		//draw text
		font.draw(batch, str, 0, 475);
		batch.end();
		shapes.begin(ShapeType.Filled);
		shapes.setColor(.5f, .5f, 0f, 1);
		shapes.rect(world.platform.position.x, world.platform.position.y, world.platform.bounds.width, world.platform.bounds.height);
		shapes.setColor(0f, 0f, 0f, 1);
		shapes.rect(0, 0, 480, 95); 
		shapes.end();
	
	}
}

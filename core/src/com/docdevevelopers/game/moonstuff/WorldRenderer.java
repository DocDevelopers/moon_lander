 package com.docdevevelopers.game.moonstuff;

import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;
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

	public WorldRenderer (SpriteBatch batch, World world) {
		this.world = world;
		this.cam = new OrthographicCamera(320, 480);
		this.cam.position.set(320 / 2, 480 / 2, 0);
		this.batch = batch;
		this.shapes = new ShapeRenderer();
	}

	public void render () {
		//if (world.bob.position.y > cam.position.y) cam.position.y = world.bob.position.y;
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		shapes.setProjectionMatrix(cam.combined);
		renderBackground();
		renderObjects();
	}

	public void renderBackground () {
		batch.disableBlending();
		batch.begin();
		batch.draw(Assets.backgroundRegion,0,0,320,480);
		batch.end();
	}

	public void renderObjects () {
		batch.enableBlending();
		batch.begin();
		if(world.state == 0)
			batch.draw(Assets.TRegion, world.ship.position.x, world.ship.position.y, Assets.TRegion.getRegionWidth(), Assets.TRegion.getRegionHeight());
		
		else if(world.state == 1)
			batch.draw(Assets.shipRegion, world.ship.position.x, world.ship.position.y, Assets.shipRegion.getRegionWidth(), Assets.shipRegion.getRegionHeight());
			
		else if(world.state == 2)
			batch.draw(Assets.CRegion, world.ship.position.x, world.ship.position.y, Assets.CRegion.getRegionWidth(), Assets.CRegion.getRegionHeight());
		
		batch.end();
		renderShapes();
	}
	
	private void renderShapes()
	{
		shapes.begin(ShapeType.Filled);
		 shapes.setColor(0f, 0f, 0f, 1);
		 shapes.rect(0, 0, 480, 95);
		 shapes.rect(world.platform.position.x, world.platform.position.y, world.platform.bounds.width, world.platform.bounds.height);
		 
		 shapes.end();
	}
	
	
	

}

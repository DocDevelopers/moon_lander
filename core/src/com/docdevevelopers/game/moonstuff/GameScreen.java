
package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.docdevevelopers.game.moonstuff.World.WorldListener;

public class GameScreen implements Screen 
{

	static final int GAME_READY = 0;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;
	static final int GAME_LEVEL_END = 3;
	static final int GAME_OVER = 4;

	static Game game;

	int state;
	OrthographicCamera guiCam;
	Vector3 touchPoint;
	SpriteBatch batcher;
	World world;
	WorldListener worldListener;
	WorldRenderer renderer;
	
	public GameScreen (Game game) {
		this.game = game;

		state = GAME_READY;
		guiCam = new OrthographicCamera(320, 480);
		guiCam.position.set(320 / 2, 480 / 2, 0);
		touchPoint = new Vector3();
		batcher = new SpriteBatch();
		//create shape batcher here
		world = new World(worldListener);
		renderer = new WorldRenderer(batcher, world);
	}
		
		
	public void draw () {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render();
		guiCam.update();
	}
		
	public void update (float deltaTime) {
		updateRunning(deltaTime);

	}
	@Override
	public void render(float delta) {
		update(delta);
		draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	private void updateRunning(float deltaTime)
	{
		ApplicationType appType = Gdx.app.getType();

		// should work also with Gdx.input.isPeripheralAvailable(Peripheral.Accelerometer)
		if(appType == ApplicationType.Desktop || appType == ApplicationType.WebGL)
		{
			Gdx.input.setInputProcessor(new KeyHandler());
			if(world.state == 2)
			{
				// Do nothing!!!
			}
			else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
			{
				world.update(deltaTime, -1f,false);
			}
			else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
			{
				world.update(deltaTime, 1f,false);
			}
			else if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
			{
				world.update(deltaTime,0f,true);
			}
			else
			{
				world.update(deltaTime, 0f,false);
			}
		}
			
			
			
	}
	
	public static void setScreen()
	{
		game.setScreen(new MainMenuScreen(game));
	}

}

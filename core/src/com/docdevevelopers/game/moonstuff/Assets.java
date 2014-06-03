package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets 
{
	public static Texture background,sprites,ship;
	public static Sound song;
	public static TextureRegion smallAsteroid,mediumAsteroid,largeAsteroid,shipRegion,backgroundRegion;

	public static Texture loadTexture (String file) 
	{
		return new Texture(Gdx.files.internal(file));
	}
	

		
		
	
	
	public static void load()
	{
		/*
		background = loadTexture("data/space.png");
		
		sprites = loadTexture("data/sprites.png");
		
		backgroundRegion = new TextureRegion(background,0,0,256,512);
		
		
		smallAsteroid = new TextureRegion(sprites, 184, 67, 256, 256);
		mediumAsteroid = new TextureRegion(sprites, 106, 41, 256, 256);
		largeAsteroid = new TextureRegion(sprites, 11, 8, 256, 256);
		shipRegion = new TextureRegion(sprites, 16, 116, 256, 256);
		*/
		ship = loadTexture("rocket.png");
		song = Gdx.audio.newSound(Gdx.files.internal("soundTrack.mp3"));
		song.play();
		shipRegion = new TextureRegion(ship, 0, 0, 39, 59);
	}
}

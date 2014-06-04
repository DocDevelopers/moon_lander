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
	public static Texture background,sprites,ship,T,C;
	public static Sound song;
	public static TextureRegion shipRegion,backgroundRegion,TRegion,CRegion;

	public static Texture loadTexture (String file) 
	{
		return new Texture(Gdx.files.internal(file));
	}
	

		
		
	
	
	public static void load()
	{
	
		background = loadTexture("spacely.jpg");
		ship = loadTexture("rocket.png");
		T = loadTexture("rocketT.png");
		C = loadTexture("rocketW_FIRE.png");
		song = Gdx.audio.newSound(Gdx.files.internal("soundTrack.mp3"));
		song.play();
		
		TRegion = new TextureRegion(T,0,0,39,59);
		shipRegion = new TextureRegion(ship, 0, 0, 39, 59);
		CRegion = new TextureRegion(C,0,0,39,59);
		backgroundRegion = new TextureRegion(background,0,0,320,480);
	}
}

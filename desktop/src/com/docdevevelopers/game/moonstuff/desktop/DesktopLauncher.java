package com.docdevevelopers.game.moonstuff.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.docdevevelopers.game.moonstuff.MoonLander;
import com.docdevevelopers.game.moonstuff.MoonLander;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 300;
		config.height = 400;
		new LwjglApplication(new MoonLander(), config);
	}
}

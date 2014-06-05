package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.Game;

public class MoonLander extends Game{
	@Override
	public void create () {
		Assets.load();
		setScreen(new GameScreen(this));
		
	}

	@Override
	public void render() {
		super.render();
	}

	/** {@link Game#dispose()} only calls {@link Screen#hide()} so you need to override {@link Game#dispose()} in order to call
	 * {@link Screen#dispose()} on each of your screens which still need to dispose of their resources. SuperJumper doesn't
	 * actually have such resources so this is only to complete the example. */
	@Override
	public void dispose () {
		super.dispose();
		getScreen().dispose();
	}
}

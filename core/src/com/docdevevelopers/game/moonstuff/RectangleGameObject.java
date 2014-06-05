package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RectangleGameObject {
	public final Vector2 position;
	public final Rectangle bounds;

	public RectangleGameObject (float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.bounds = new Rectangle(x/2, y/2, width, height);
	}
}
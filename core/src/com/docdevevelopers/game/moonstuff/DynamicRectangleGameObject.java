package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.math.Vector2;

public class DynamicRectangleGameObject extends RectangleGameObject {
	public final Vector2 velocity;
	public final Vector2 accel;

	public DynamicRectangleGameObject (float x, float y, float width, float height) {
		super(x, y, width, height);
		velocity = new Vector2();
		accel = new Vector2();
	}
}
package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.math.Vector2;

public class DynamicCircleGameObject extends CircleGameObject {
	public final Vector2 velocity;
	public final Vector2 accel;

	public DynamicCircleGameObject (float x, float y, float width, float height) {
		super(x, y, width, height);
		velocity = new Vector2();
		accel = new Vector2();
	}
}
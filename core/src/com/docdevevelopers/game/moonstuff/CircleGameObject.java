package com.docdevevelopers.game.moonstuff;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CircleGameObject {
	public final Vector2 position;
	public final Circle bounds;

	public CircleGameObject (float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.bounds = new Circle(position,width/2);
	}
}
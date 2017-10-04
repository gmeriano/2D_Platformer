//@author(Chris.Miller)
//@version(May 4, 2017)
package game.level;

import game.physics.AABoundingRect;
import game.physics.BoundingShape;

public abstract class LevelObject {// handles any objects that appear in the level. Most
							// variables are accessible via setters and getters,
							// since these objects are used like everywhere.

	protected float x;
	protected float y;
	protected BoundingShape shape;

	protected float horizSpeed = 0;
	protected float vertSpeed = 0;
	protected float maxFallSpeed = 1;

	protected boolean onGround = true;

	public LevelObject(float x, float y) {
		this.x = x;
		this.y = y;

		shape = new AABoundingRect(x, y, 32, 32);
	}

	// this implements vertical acceleration. The object's speed in the downward
	// direction will increase until it hits a maximum speed we are calling "1".
	// if in the process of increasing the speed, the vertical velocity excedes
	// "1", then it will be set to 1.
	public void initGravity(float gravity) {
		if (vertSpeed < maxFallSpeed) {
			vertSpeed += gravity;
			if (vertSpeed > maxFallSpeed) {
				vertSpeed = maxFallSpeed;
			}
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
		updateShape();
	}

	public void setY(float y) {
		this.y = y;
		updateShape();
	}

	public float getHorizSpeed() {
		return horizSpeed;
	}

	public void setHorizSpeed(float speed) {
		horizSpeed = speed;
	}

	public float getVertSpeed() {
		return vertSpeed;
	}

	public void setVertSpeed(float speed) {
		vertSpeed = speed;
	}

	public boolean isOnGround() {
		return onGround;
	}

	public void setOnGround(boolean b) {
		onGround = b;
	}

	public BoundingShape getShape() {
		return shape;
	}

	public void updateShape() {
		shape.movePosition(x, y);
	}

}

//@author(Chris.Miller)
//@version(May 4, 2017)
package game.level.tile;

import game.physics.BoundingShape;

public class Tile {

	protected int x;
	protected int y;
	protected BoundingShape shape;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void move(int xMove, int yMove) {
		x += xMove;
		y += yMove;
	}

}

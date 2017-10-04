//@author(Chris.Miller)
//@version(May 4, 2017)
package game.level.tile;

import game.physics.AABoundingRect;

public class ClosedTile extends Tile {

	public ClosedTile(int x, int y) {
		super(x, y);
		super.shape = new AABoundingRect(x * 32, y * 32, 32, 32);
	}

}

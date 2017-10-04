//@author(Chris.Miller)
//@version(May 4, 2017)
package game.physics;

import java.util.ArrayList;

import game.level.tile.Tile;
import game.physics.AABoundingRect;

public abstract class BoundingShape {

	public boolean checkCollision(BoundingShape bv) {
		if (bv instanceof AABoundingRect) return checkCollision((AABoundingRect) bv);
		return false;
	}

	public abstract boolean checkCollision(AABoundingRect box);

	public abstract void updatePosition(float newX, float newY);

	public abstract ArrayList<Tile> getTilesOccupying(Tile[][] tiles);

	public abstract ArrayList<Tile> getClosedTiles(Tile[][] tiles);

	public abstract void movePosition(float x, float y);
}

//@author(Chris.Miller)
//@version(May 4, 2017)
package game.physics;

import java.util.ArrayList;

import game.level.tile.Tile;

public class AABoundingRect extends BoundingShape {

	public float x;
	public float y;
	public float width;
	public float height;

	public AABoundingRect(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void updatePosition(float newX, float newY) {
		this.x = newX;
		this.y = newY;
	}

	public void movePosition(float x, float y) {
		this.x += x;
		this.y += y;
	}

	// I got this far basically on my own, using techniques I learned from
	// several different sources etc online. After here, I was unsure, and
	// frums.nl had a section specifically on collision, so we will probably
	// implement that method. The author has a good diagram and explanation that
	// definitely helped me (Chris) understand the collision checking.
	@Override
	public boolean checkCollision(AABoundingRect box) {

		return !(box.x > this.x + width || box.x + box.width < this.x || box.y > this.y + height
				|| box.y + box.height < this.y);
		// reading it over a couple times, this makes sense to me. Basically, if
		// any part of the new box can be within any part of this box, then it
		// returns true.
		// to do this, it checks each of four sides for a space. If any of them
		// return true, then the two boxes cannot be touching/colliding. If none
		// of these returns true, the only possibility is a collision.
	}

	@Override // TODO test this without the modulus operation. See why it fails,
				// as multiple sources claim it will. This method checks to see
				// what tiles are occupied by a bounding Box.
	public ArrayList<Tile> getTilesOccupying(Tile[][] tiles) {
		ArrayList<Tile> occupiedTiles = new ArrayList<Tile>();
		for (int i = (int) x; i <= x + width + (32 - width % 32); i += 32) {
			for (int j = (int) y; j <= y + height + (32 - height % 32); j += 32) {
				occupiedTiles.add(tiles[i / 32][j / 32]);
			}
		}

		return occupiedTiles;
	}

	@Override
	public ArrayList<Tile> getClosedTiles(Tile[][] tiles) {// this checks for
															// any tiles
															// directly below
															// where the player
															// is standing

		ArrayList<Tile> tilesBelow = new ArrayList<Tile>();
		int j = (int) (y + height + 1);

		for (int i = (int) x; i <= x + width + (32 - width % 32); i += 32) {
			tilesBelow.add(tiles[i / 32][j / 32]);
		}

		return tilesBelow;
	}
}

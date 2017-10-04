//@author(Chris.Miller)
//@version(May 3, 2017)
//This was the sample on frums.nl. This is very very basic boilerplate stuff. There is going to be pseudo-procedural generation.
//The level/map will change after each one is finished, added on to an ArrayList. As the player approaches the end of the stored 'chunks' (we are thinking about ten),
//here the program will randomly select more 'chunks' to append to the ArrayList.

package game.level;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import game.character.Character;
import game.level.tile.ClosedTile;
import game.level.tile.OpenTile;
import game.level.tile.Tile;

public class Level {

	private int x;
	
	private TiledMap currentMap;
	private ArrayList<Character> characters;
	Tile[][] tiles;

	public Level(String lvl) throws SlickException {
		currentMap = new TiledMap("data/levels/" + lvl + ".tmx", "data/img");
		characters = new ArrayList<Character>();
		// Character nerd = new Character(0f,0f);
		// characters.add(nerd);
		x = 0; 
		initTiles();

	}

	public void insertCharacter(Character c) {
		characters.add(c);
	}

	public void initTiles() {
		tiles = new Tile[currentMap.getWidth()][currentMap.getHeight()];

		int layerIndex = currentMap.getLayerIndex("SmashLayer");
		if (layerIndex == -1) {
			System.err.println("Map is missing the \"SmashLayer\" layer. Please add one to handle collisions.");
			System.exit(0);
		}

		for (int x = 0; x < currentMap.getWidth(); x++) {
			for (int y = 0; y < currentMap.getHeight(); y++) {

				int tileID = currentMap.getTileId(x, y, layerIndex);

				Tile loader = null;
				switch (currentMap.getTileProperty(tileID, "blocked", "true")) {
				case "false":
					loader = new OpenTile(x, y);
					break;
				case "true":
					loader = new ClosedTile(x, y);
					break;
				default:
					loader = new ClosedTile(x, y);
				}
				tiles[x][y] = loader;

			}
		}
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public ArrayList<Character> getChars() {
		return characters;
	}

	public void render(Camera cam) {
			currentMap.render((int)cam.getX(), (int)cam.getY(), 0, 0, 32, 18);
			for (Character c : characters) {
				c.render();
			}
	}
	
	public void setX(int dist) {
		x += dist;
	}

}

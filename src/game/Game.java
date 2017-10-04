//@author(Chris.Miller)
//@version(May 3, 2017)
//The main class of the game, makes a window, and runs the game in the window in a default state.
package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import game.state.LevelState;

public class Game extends StateBasedGame {

	// changeable width, and the height is based on it
	public static final int WINDOW_WIDTH = 1280;
	public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 16 * 9;
	public static final boolean IS_FULLSCREEN = false; // game will stay in
														// windowed mode

	// This is a scale modifier, 1.25 in this case. This was found on frums.nl,
	// as this is where I learned the Slick2D and LWJGL libraries relevant to my
	// game. I also used The Java Blog.
	// The point of this is that on any screen, with any native res, the same
	// amount of information is displayed. Back when I was working with Swing,
	// this was a MASSIVE issue.
	// This resolution to the issue appears very elegant to me, so I will
	// attempt implementing it myself.
	public static final float SCALE = (float) (1.25 * ((double) WINDOW_WIDTH / 1280));
	public static final String GAME_NAME = "Escape from Hackermania";

	public Game() {
		super(GAME_NAME);
	}

	public void initStatesList(GameContainer container) throws SlickException {
		addState(new LevelState("lvl_1"));
		this.enterState(0);
	}

	public static void main(String argv[]) throws SlickException {
		AppGameContainer winder = new AppGameContainer(new Game());// as in
																	// window.
																	// ha. ha
																	// ha.

		winder.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, IS_FULLSCREEN);
		winder.setTargetFrameRate(60);

		winder.start();
	}

}

//@author(Chris.Miller)
//@version(May 3, 2017)
//generally an extremely generic and simple class. Just loads the initial level and then scales it according the game scale factor in Game.java
package game.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.Game;
import game.character.Player;
import game.controller.MKBPlayerController;
import game.controller.PlayerController;
import game.level.Camera;
import game.level.Level;
import game.physics.Physics;

public class LevelState extends BasicGameState {

	Level lvl;
	String initLvl;
	private Player player;
	private PlayerController controller;
	private Physics physics;
	private Camera cam;

	public LevelState(String initLvl) {
		this.initLvl = initLvl;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

		lvl = new Level(initLvl);

		player = new Player(128,416); //TODO change
		cam = new Camera(player);
		lvl.insertCharacter(player);
		controller = new MKBPlayerController(player, cam);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.scale(Game.SCALE, Game.SCALE);
		lvl.render(cam);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		controller.handleInput(container.getInput(), delta);
		//physics.handlePhysics(lvl, delta);
	}

	@Override
	public void keyPressed(int key, char code) {
		if (key == Input.KEY_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}

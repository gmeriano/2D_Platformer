//@author(Chris.Miller)
//@version(May 4, 2017)
package game.controller;

import org.newdawn.slick.Input;

import game.character.Player;

public abstract class PlayerController {
	protected Player player;
	
	public PlayerController(Player player){
		this.player = player;
	}
	
	public abstract void handleInput(Input i, int delta);
}

//@author(Chris.Miller)
//@version(May 4, 2017)
//Handles specifically the player's character positions.
package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import game.character.Character;
public class Player extends Character {

	public Player(float x, float y) throws SlickException {
		super(x, y);
		sprite = new Image("/data/img/characters/player/Duderino.png");
		
		
		acceleration = .0001f;
		maxSpeed = .15f;
		maxFallSpeed = .3f;
		deceleration = .001f;
	}
	
	public void updateBounds(){
		shape.updatePosition(x, y);//edits here e.g. x+int compensate for the player sprite not being exactly 32 pixels wide/tall
	}
	
	public void moveRight(float xMov){
		x -= xMov*.15f;
	}
	
	public void moveLeft(float xMov){
		x -= xMov*.15f;
	}
	
	public void moveY(float yMov){
		y -= yMov*.15f;
	}
}

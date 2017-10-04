//@author(Chris.Miller)
//@version(May 4, 2017)
//Handles any characters in the game.
package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.level.LevelObject;

public abstract class Character extends LevelObject {

	//protected float x;
	// protected variables are accessible by subclasses, the
	// class it was declared in,
	// and classes in the same package
	//protected float y;
	protected Image sprite;
	protected boolean moving = false;
	protected float acceleration;
	protected float deceleration;
	protected float maxSpeed;
	
	
	public Character(float x, float y) throws SlickException {
		super(x,y);
		sprite = new Image("/data/img/characters/player/Duderino.png");
	}
	
	public void decelerate(int delta){
		if(horizSpeed > 0){
			horizSpeed -= deceleration * delta;
			if(horizSpeed < 0){
				horizSpeed = 0;
			}
		}if(horizSpeed < 0){
			horizSpeed += deceleration * delta;
			if(horizSpeed > 0){
				horizSpeed = 0;
			}
		}
	}
	
	public void moveLeft(int delta){
		if(horizSpeed > -maxSpeed){
			horizSpeed -= acceleration*delta;
			if(horizSpeed < -maxSpeed){
				horizSpeed = -maxSpeed;
			}
		}
		moving = true;
		//facing = facing.LEFT; for animations
	}
	
	public void moveRight(int delta){
		if(horizSpeed < maxSpeed){
			horizSpeed += acceleration*delta;
			if(horizSpeed > maxSpeed){
				horizSpeed = maxSpeed;
			}
		}
		moving = true;
		//facing = facing.RIGHT; for animations
	}
	
	public void jump(){
		if(onGround) vertSpeed = -4;//DO YOU HAVE ANY IDEA HOW CONFUSING IT IS THAT UP IS NEGATIVE?
	}
	
	
	public boolean isMoving(){
		return moving;
	}
	public void setMoving(boolean m){
		moving = m;
	}
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void render() {
		sprite.draw(x, y);// draws Image
	}
}

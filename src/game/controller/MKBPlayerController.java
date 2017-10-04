//@author(Chris.Miller)
//@version(May 4, 2017)
package game.controller;

import org.newdawn.slick.Input;
import org.newdawn.slick.tiled.TiledMap;

import game.character.Player;
import game.level.Camera;
import game.level.Level;

public class MKBPlayerController extends PlayerController{

	private Camera cam;
	
	public MKBPlayerController(Player player,Camera camera){
		super(player);
		cam = camera;
	}
	
	public void handleInput(Input i, int delta) {
		handleKBIn(i,delta);
		
	}
	
	public void handleKBIn(Input i, int delta){
		if(i.isKeyDown(Input.KEY_LEFT)){
			player.moveLeft(delta);
			cam.moveX(delta);
			
		}else if(i.isKeyDown(Input.KEY_RIGHT)){
			player.moveRight(delta);
			cam.moveX(-delta);
		}else{
			player.setMoving(false);
		}
		
		if(i.isKeyDown(Input.KEY_SPACE)){
			player.jump();
			cam.moveY(delta);
		}
	}
	
}

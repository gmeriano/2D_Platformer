package game.level;

import game.character.Player;

public class Camera {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = (1280 / 16 * 9)+100;
	
	private float cameraSizeX;
	private float cameraSizeY;
	
	private float maxPositionX;
	private float maxPositionY;
	private float minPositionX;
	private float minPositionY;
	
	private Player player;
	
	private float x;
	private float y;
	
	public Camera(Player player) {
		maxPositionX = 25;//WORLD_SIZE_X - cameraSizeX;
		maxPositionY =25;// WORLD_SIZE_Y - cameraSizeY;
		minPositionX = -25;//-WORLD_SIZE_X + cameraSizeX;
		minPositionY = -25;//-WORLD_SIZE_Y + cameraSizeY;
		x = 0; y = 0;
		this.player = player;
	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
	public void moveX(float xMov) {
		if (xMov < 0) {
			System.out.println("PLAYER X: "+player.getX());
			if (player.getX() < 400)
				player.moveRight(xMov);
			else
				x += xMov*.15;
		}
		else {
			System.out.println("PLAYER X: "+player.getX());
			if (player.getX() > 400)
				player.moveLeft(xMov);
			else
				x -= xMov*.15;
		}
	}	
	public void moveY(float yMov) {
			y += yMov*.15;
	}
	
}

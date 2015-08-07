package game;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


public class Main {

	public static boolean running;
	static GraphicsDevice gd;
	
	public static void main(String[] args) {
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		running = true;
		Game.startGame();

	}

}

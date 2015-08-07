package game;
import java.util.ArrayList;


public class Game {
	
	public static MainWindow mainWindow;
	public static Avatar ship;
	public static ArrayList<Asteroid> asteroids;
	static Thread gameLoopThread;
	
	public static void startGame(){
		ship = new Avatar();
		asteroids = new ArrayList<Asteroid>();
		asteroids.add(new Asteroid(200,200,20,.01,true,false,-.5,1));
		mainWindow = new MainWindow();
		gameLoopThread = new Thread(new GameLoop());
		gameLoopThread.start();
		
	}
	
	

}

package game;


import javax.swing.SwingUtilities;


public class GameLoop implements Runnable{

	
		long recordedTime;
		long runTime;
		long nano = 1_000_000_000;
		double delay = nano / 120;
		long before;
		long now;
		long elapsed;
		int count = 0;
		
		@Override
		public void run() {
			
			before = System.nanoTime();
			
			while(true){
				
				now = System.nanoTime();
				elapsed = now - before;
				
				if(elapsed >= delay){
					before = now;
					Game.ship.updateAvatar();
					Game.asteroids.forEach(a -> a.updateAsteroid());
					SwingUtilities.invokeLater(() ->Game.mainWindow.repaint());
						
				}	
			}
		}
}

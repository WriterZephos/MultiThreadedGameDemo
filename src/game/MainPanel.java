package game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MainPanel extends JPanel{
	
	Image background;
	
	MainPanel(){
		
		setMinimumSize(new Dimension(1240,775));
		setPreferredSize(new Dimension(1240,775));
		
		
		URL url = Main.class.getResource("/resources/stars.jpg");
		background = new ImageIcon(url).getImage();
				
				//new ImageIcon(MainPanel.class.getResource("/stars.jpg")).getImage();
		
		setOpaque(true);
		setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawImage(background, 0, 0, null);
		Game.ship.drawAvatar(g);
		Game.asteroids.forEach(a -> a.drawAsteroid(g));
		
	}

}

package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public class Asteroid {

	
	Image sprite1 = null;
	int size;
	double x;
	double y;
	
	double velocity = 0.01;
	double residualVelocityX = 0;
	double residualVelocityY = 0;
	double angle = 0;
	double rotation = 0;
	
	boolean accelerating = false;
	boolean rotatingLeft = false;
	boolean rotatingRight = false;
	
	
	public Asteroid(int x, int y, int size,double rot, boolean rotLeft, boolean rotRight,double velX, double velY){
		
		URL url = Main.class.getResource("/resources/Asteroid.png");
		sprite1 = new ImageIcon(url).getImage().getScaledInstance(size*10,size*10, Image.SCALE_DEFAULT);
		rotation = rot;
		rotatingLeft = rotLeft;
		rotatingRight = rotRight;
		residualVelocityX = velX;
		residualVelocityY = velY;
		this.size = size;	
		this.x = x;
		this.y = y;
		
	}
	
public void updateAsteroid(){
		
		angle += rotation;
		
		if(angle > Math.PI*2){
			angle -= Math.PI*2;
		} else if(angle < 0){
			angle += Math.PI*2;
		}
		
		x += residualVelocityX;
		y += residualVelocityY;
		
		if(x + (size*5) > 1240) x -= 1240 + residualVelocityY;
		if(x < -(size*5)) x += 1240 + residualVelocityY;
		if(y + (size*5) > 775) y -= 775 + residualVelocityY;
		if(y < -(size*5)) y += 775 + residualVelocityY;
	}
	
	public void drawAsteroid(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.RED);
		g2d.rotate(angle, x + (size*5), y + (size*5));
		g2d.drawImage(sprite1, (int) Math.rint(x), (int) Math.rint(y), null);
		g2d.dispose();
	}
	
}


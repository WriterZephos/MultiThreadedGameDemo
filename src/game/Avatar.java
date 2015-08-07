package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public class Avatar {
	
	double x = 0;
	double y = 0;
	
	double velocity = 0.01;
	double velocityX = 0;
	double velocityY = 0;
	double angle = 0;
	double rotation = 0;
	double residualVelocityX = 0;
	double residualVelocityY = 0;
	double remainderX = 0;
	double remainderY = 0;
	
	boolean accelerating = false;
	boolean decelerating = false;
	boolean rotatingLeft = false;
	boolean rotatingRight = false;
	
	
	Image sprite1 = null;
	Image sprite2 = null;
	
	
	
	
	public Avatar(){
		x = 300;
		y = 300;
		
		URL url = Main.class.getResource("/resources/XWing1.png");
		sprite1 = new ImageIcon(url).getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
		url = Main.class.getResource("/resources/XWing2.png");
		sprite2 = new ImageIcon(url).getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
	}
	
	public void updateAvatar(){
		
		double rise = 0;
		double run = 0;
		int xDir = 0;
		int yDir = 0;
		
		if(rotatingLeft && rotation > -.05){
			rotation -= .01;
		}
		
		if(rotatingRight && rotation < .05){
			rotation +=.01;
			
		}
		if(!(rotatingRight || rotatingLeft)){
			rotation *= .01;
		}
		
		if(angle > Math.PI*2){
			angle -= Math.PI*2;
		} else if(angle < 0){
			angle += Math.PI*2;
		}
		angle += rotation;
		
		
		double theta = 0;
		double beta = (Math.PI / 2) - angle;
		
		if (angle <= (Math.PI / 2)){
			
			theta = angle;
			beta = (Math.PI / 2) - theta;
			xDir = 1;
			yDir = 1;
			
		} else if(angle > (Math.PI / 2) && angle <= Math.PI){
	
			beta = (Math.PI / 2) - (Math.PI - angle);
			theta = (Math.PI / 2) - beta;
			xDir = -1;
			yDir = 1;
			
		} else if(angle > Math.PI && angle <= ((3 * Math.PI) / 2)){
	
			beta = (Math.PI / 2) - Math.abs((Math.PI - angle));
			theta = (Math.PI / 2) - beta;
			xDir = -1;
			yDir = -1;
		}
		else if (angle > (3 * (Math.PI / 2)) && angle <= (2 * Math.PI)){
			
			beta = (Math.PI / 2) - ((2 * Math.PI) - angle);
			theta = (2 * Math.PI) - angle;
			xDir = 1;
			yDir = -1;
		
		}
		
		rise = ((Math.sin(theta) * 55)/2);
		run = ((Math.sin(beta) * 55)/2);
		
		if(accelerating) {
			
			double distance = Math.hypot(rise, run);
			double divider = distance/2;
			velocityX = (xDir * run/divider)*velocity;
			velocityY = (yDir * rise/divider)*velocity;
		} 
			
		double friction = 0.004;
		if(decelerating) friction += 0.004;
		
		if(residualVelocityX > friction) residualVelocityX -= friction;
		if(residualVelocityX < -friction) residualVelocityX += friction;
		if(residualVelocityY > friction) residualVelocityY -= friction;
		if(residualVelocityY < -friction) residualVelocityY += friction;
		
		residualVelocityX += velocityX;
		residualVelocityY += velocityY;
		
		velocityX = 0;
		velocityY = 0;
		
		x += residualVelocityX;
		y += residualVelocityY;
		
		if(x + 55 > 1240) x -= 1240 + residualVelocityX;
		if(x < -55) x += 1240 + residualVelocityX;
		if(y + 55 > 775) y -= 775 + residualVelocityY;
		if(y < -55) y += 775 + residualVelocityY;
		
		
//		x += 2;
//		if(x + 55 > 1240) x -= 1240 + 2;
		
	}
	
	public void drawAvatar(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.RED);
		g2d.rotate(angle, x + 55, y + 55);
		g2d.drawImage(accelerating ? sprite2 : sprite1, (int) Math.rint(x), (int) Math.rint(y), null);
		g2d.dispose();
	}
	
	
}

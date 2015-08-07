package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainWindow extends JFrame{

	MainWindow(){
		super("DemoGame");
		setBounds(0,0,1240,775);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new MainPanel());
		//getContentPane().add(new JButton("here"));
		//this.setOpacity(1f);
		setBackground(Color.BLUE);
		setVisible(true);
		revalidate();
		repaint();
		
		addKeyListener(new KeyListener(){

			int keysPressed = 0;
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyCode());
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
			    switch( key ) { 
			        case KeyEvent.VK_UP:
			        	Game.ship.accelerating = true;;
			            break;
			        case KeyEvent.VK_DOWN:
			        	Game.ship.decelerating = true;
			            break;
			        case KeyEvent.VK_LEFT:
			        	Game.ship.rotatingLeft = true;
			            break;
			        case KeyEvent.VK_RIGHT :
			        	Game.ship.rotatingRight = true;
			            break;
			     }
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
			    switch( key ) { 
			        case KeyEvent.VK_UP:
			        	Game.ship.accelerating = false;
			            break;
			        case KeyEvent.VK_DOWN:
			        	Game.ship.decelerating = false;
			            break;
			        case KeyEvent.VK_LEFT:
			        	Game.ship.rotatingLeft = false;
			            break;
			        case KeyEvent.VK_RIGHT :
			        	Game.ship.rotatingRight = false;
			            break;
			     }
				
			}});
	}
	
	
	
}

package notification;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JLabel;

import control.*;

public class GameNotificationHelper extends JLabel{
	
	int xPos = -1;
	int yPos = -1;
	int width = 100;
	int height = 50;
	String m = "Start the game!";
	
	Color backgroundColor = new Color(255,255,255);
	Color textColor = Color.orange;
	ArrayList<GameNotification> listNotification = new ArrayList<GameNotification>();
	
	private GameController gameController;
	
	public GameNotificationHelper() {
//		this.gameController = gameController;
	}
	
	void testPaint() {
		GameNotification note1 = new GameNotification();
		GameNotification note2 = new GameNotification();
		GameNotification note3 = new GameNotification();
	}
	
	public void setPos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setM(String m) {
		this.m = m;
	}
	
	public String getM() {
		return this.m;
	}
	
	public void setPosSize(int x, int y, int w, int h) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.height = h;
	}
	
	public void setTheme1() {
		backgroundColor = new Color(255,255,255);
		textColor = Color.orange;
	}
	
	public void setTheme2() {
		backgroundColor = new Color(24,71,142);
		textColor = Color.white;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 3*height/4));
        
        g2.setColor(backgroundColor);
        g2.fillRect(xPos, yPos, width, height);
        
        g2.setColor(textColor);
        g2.drawString(this.m, xPos + width/4 - 20, yPos + 3*height/4);
		
	}
	
}

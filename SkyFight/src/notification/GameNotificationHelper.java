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
	
	int numberMessage = 4;

	String headMessage;
	int xPosHeadMessage = 515;
	int yPosHeadMessage = 321;
		
	Color backgroundColor = new Color(255,255,255);
	Color textColor = Color.orange;
	ArrayList<String> listMessage = new ArrayList<String>();
		
	public GameNotificationHelper() {
		this.initNotice();
	}
	
	public void initNotice() {
		listMessage.clear();
		listMessage.add("");
		listMessage.add("");
		listMessage.add("");
		listMessage.add("");
		listMessage.add("");
	}
	
	public void setPos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void addNotice(String m) {
		this.listMessage.add(0, m);
	}
	
	public void setPosSize(int x, int y, int w, int h) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.height = h;
	}
	
	public void setNumberMessage(int num) {
		this.numberMessage = num;
	}
	
	public void setHeadMessage(String msg) {
		this.headMessage = msg;
	}
	
	public void setPosHeadMessage1() {
		this.xPosHeadMessage = 515;
		this.yPosHeadMessage = 321;
	}
	
	public void setPosHeadMessage2() {
		this.xPosHeadMessage = 677;
		this.yPosHeadMessage = 470;	
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
        g2.setFont(new Font("Monospaced", Font.BOLD, 3*height/4));
                
        for(int i = 0; i < numberMessage; i++) {
        	if(listMessage.get(i) != null && listMessage.size() >= i) {        		
        		g2.setColor(backgroundColor);
        		g2.fillRect(xPos, yPos + height * i, width, height);
        		g2.setColor(Color.gray);
        		g2.drawRect(xPos, yPos + height * i, width, height);
        		
        		g2.setColor(textColor);
        		g2.drawString(listMessage.get(i), xPos + 20, yPos + 3*height/4  + height * i);
        	}
        }
        
        if(headMessage != null) {        	
        	g2.setColor(backgroundColor);
        	g2.fillRect(xPosHeadMessage, yPosHeadMessage, width, height);
        	g2.setColor(Color.gray);
        	g2.drawRect(xPosHeadMessage, yPosHeadMessage, width, height);
        	
        	g2.setColor(textColor);
        	g2.drawString(headMessage, xPosHeadMessage + 20, yPosHeadMessage + 3*height/4);
        }
        
	}
	
}

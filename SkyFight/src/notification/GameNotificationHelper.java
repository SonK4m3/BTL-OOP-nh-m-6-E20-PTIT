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
	ArrayList<String> listNotices = new ArrayList<String>();
		
	public GameNotificationHelper() {
		this.initNotice();
	}
	
	/*
	 * initial empty list notification to display
	 */
	public void initNotice() {
		listNotices.clear();
		listNotices.add("");
		listNotices.add("");
		listNotices.add("");
		listNotices.add("");
		listNotices.add("");
	}

	/*
	 * add notice to first of list notices
	 */
	public void addNotice(String m) {
		this.listNotices.add(0, m);
	}
	
	/*
	 * set position and size of message notification in ativity
	 */
	public void setPosSize(int x, int y, int w, int h) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.height = h;
	}
	
	public void setNumberMessage(int num) {
		this.numberMessage = num;
	}
	/*
	 * numbers of list message will show
	 */
	public void setHeadMessage(String msg) {
		this.headMessage = msg;
	}
	
	/*
	 * 	change position of head message
	 * 
	 */
	public void setPosHeadMessage1() {
		this.xPosHeadMessage = 515;
		this.yPosHeadMessage = 321;
	}
	
	public void setPosHeadMessage2() {
		this.xPosHeadMessage = 677;
		this.yPosHeadMessage = 470;	
	}
	
	/*
	 * change theme color, style
	 * 
	 */
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
		// 1. set font and size of text
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Monospaced", Font.BOLD, 3*height/4));
        // 2. display message panel and list notification      
        for(int i = 0; i < numberMessage; i++) {
        	if(listNotices.get(i) != null && listNotices.size() >= i) {        		
        		g2.setColor(backgroundColor);
        		g2.fillRect(xPos, yPos + height * i, width, height);
        		g2.setColor(Color.gray);
        		g2.drawRect(xPos, yPos + height * i, width, height);
        		
        		g2.setColor(textColor);
        		g2.drawString(listNotices.get(i), xPos + 20, yPos + 3*height/4  + height * i);
        	}
        }
        // 3. display turn of player
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

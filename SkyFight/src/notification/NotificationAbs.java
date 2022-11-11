package notification;

import javax.swing.JLabel;

public abstract class NotificationAbs extends JLabel{
	
	int xPos;
	int yPos;
	
	String message;
	
	public int getX() {
		return this.xPos;
	}
	
	public int getY() {
		return this.yPos;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}

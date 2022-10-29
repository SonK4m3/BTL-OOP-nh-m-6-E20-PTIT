package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Board extends Craft{

	public Board(int x, int y) {
		super(x, y);
		this.init();
	}
	
	public void init() {
		this.width = 310;
		this.height = 310;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.gray);
		g2d.fillRect(this.x, this.y, this.width, this.height);
		g2d.setColor(Color.black);
		for(int i = this.x; i <= this.x + this.width; i+= 31) {
			g2d.drawLine(i, this.y, i, this.width + this.y);
		}
		for(int i = this.y; i <= this.y + this.height; i+= 31) {
			g2d.drawLine(this.x, i, this.height + this.x, i);
		}
	}
}

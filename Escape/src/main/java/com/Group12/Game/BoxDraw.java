package com.Group12.Game;

import java.awt.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoxDraw extends JPanel{
	
	Color clr;
	
	int xPos;
	int yPos;
	int size;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		if (clr != null) {
			g2d.setColor(clr);
		}
		
		g2d.fillRect(xPos, yPos, size, size);
	}
	
	public void setBoxColor(Color c) {
		clr = c;
	}
	
	public void setBoxVals(int xPos, int yPos, int size) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
	}
	
}

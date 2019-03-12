package bgs.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import bgs.main.CGAColor;

public class GamePanel extends BufferedImage {

	public GamePanel(int width, int height, int imageType) {
		super(width, height, imageType);
	}
	
	public void drawSquare(int x, int y, int s, Color c) {
		Graphics2D g = createGraphics();
		g.setColor(c);
		g.fillRect(x, y, s, s);
	}
	
	public void drawTestPattern() {
		Graphics2D g = createGraphics();
		g.setColor(CGAColor.RED);
		g.fillRect(100, 100, 100, 100);
	}
}

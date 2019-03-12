package bgs.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bgs.main.CGAColor;
import bgs.main.Lang;

public class GraphicsWindow {
	
	private JFrame jf;
	private JPanel jp;
	private GamePanel gp;
	
	private int xos = 0;
	private int yos = 0;
	
	public GraphicsWindow(Dimension windowSize) {
		jf = new JFrame(Lang.NAME);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp = new JPanel();//GamePanel();
		
		jp.setBackground(CGAColor.MAGENTA);
		int w = windowSize.width + jf.getInsets().left + jf.getInsets().right;
		int h = windowSize.height + jf.getInsets().left + jf.getInsets().right;
		System.out.println(w + " " + h);
		jp.setPreferredSize(new Dimension(w, h));
		jf.getContentPane().add(jp);
		
		jf.pack();
		jf.setVisible(true);
	}
	
	public void setGamePanel(GamePanel gp) {
		this.gp = gp;
		draw();
	}
	
	public void draw() {
		System.out.println("Draw");
		jp = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(gp, xos, yos, xos+1152, yos+648, 0, 0, gp.getWidth(), gp.getHeight(), CGAColor.BLACK, null);
			}
		};
		jp.repaint();
		jf.pack();
		jf.repaint();
	}
}

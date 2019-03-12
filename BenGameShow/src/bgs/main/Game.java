package bgs.main;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bgs.graphics.BSOD;
import bgs.graphics.BigThing;
import bgs.graphics.GamePanel;
import bgs.graphics.GraphicsWindow;
import util.Logger;
import util.TracedPrintStream;

public class Game {
	
	public static void main(String args[]) {
		TracedPrintStream tps = new TracedPrintStream(System.out);
		System.setOut(tps);
		Logger log = new Logger();
		
		List<String> err = new ArrayList<String>();
		for(int i = 0; i < 18; i++) {
			err.add(Integer.toString(i));
		}
		
		GraphicsWindow gw = new GraphicsWindow(new Dimension(1280, 720));
		GamePanel gp = new GamePanel(1280, 720, GamePanel.TYPE_INT_ARGB);
		gp.drawSquare(5, 5, 30, CGAColor.BLUE);
		gw.setGamePanel(gp);
	}

	public void throwBSOD(Exception e) {
		// TODO Auto-generated method stub
		new BSOD(e);
	}

}

package bgs.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;

import bgs.main.Lang;

public class BSOD {
	
	private int maxLines = 15;
	private int beforeBreak = 12;
	
	public BSOD(Throwable e) {
		if(e != null) {
			List<String> techList = new ArrayList<String>();
			for(StackTraceElement el : e.getStackTrace()) {
				techList.add(el.getClassName() + "." + el.getMethodName() + "(" + el.getFileName() + ":" + el.getLineNumber() + ")");
			}
			crash(e.getStackTrace()[0].getFileName(),  e.getMessage(), techList);
		} else {
			new BSOD(new NullPointerException("You must specify an error to report!"));
		}
	}
	public BSOD(String cause, String msg, List<String> tech) {
		crash(cause, msg, tech);
	}
	
	private void crash(String cause, String msg, List<String> tech) {
		if(cause == null) {
			cause = "";
		}
		if(msg == null) {
			msg = "";
		}
		if(tech != null) {
			int count = 0;
			while(tech.size() > maxLines) {
				tech.remove(beforeBreak);
				count++;
			}
			if(count > 0) {
				tech.add(beforeBreak, " ... Skipping " + count + " lines");
			}
		}
		
		List<String> text = new ArrayList<String>();
		text.add("A problem has been detected and BenGameShow has been shut down to avoid damage to your computer.");
		text.add("");
		text.add("The problem seems to be caused by the following source: " + cause);
		text.add("");
		text.add(msg);
		text.add("");
		text.add("If this is the first time you've seen this stop error scree, restart BenGameShow. If this screen appears again, follow these steps:");
		text.add("");
		text.add("Check to make sure any new hardware or software is properly installed.");
		text.add("If this is a new installation, ask your hardware or software manufacutrer for any BenGameShow updates you might need.");
		text.add("If problems continue, disable or remove any newly installed hardware or software.");
		text.add("Close all other running applications, and restart your computer.");
		text.add("");
		text.add("Technical information:");
		text.addAll(tech);
		
		JDialog jf = new JDialog();
		JPanel panel = new JPanel() {
        	@Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillRect(0,  0,  getWidth(), getHeight());
                g.setFont(Lang.getGameFont(Lang.FONT_UBUNTU_MONO));
                g.setColor(Color.WHITE);
                int h = g.getFontMetrics().getHeight() + 5;
                for(int i = 0; i < text.size(); i++) {
                	g.drawString(text.get(i), 5, (i*h)+24);
                }
        	}
		};
		jf.setMinimumSize(new Dimension(1280, 720));
		jf.add(panel);
        jf.validate();
        jf.setVisible(true);
	}

}

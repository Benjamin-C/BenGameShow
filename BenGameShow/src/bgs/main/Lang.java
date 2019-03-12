package bgs.main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import bgs.graphics.BSOD;

public class Lang {
	// Font data
	public static final String FONT_UBUNTU_MONO = "UbuntuMono-R.ttf";
	public static final String NAME = "Lateral";
	
	public static Font getGameFont(String file) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(file)).deriveFont(16f);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			new BSOD(e);
			return null;
		}
	}
}

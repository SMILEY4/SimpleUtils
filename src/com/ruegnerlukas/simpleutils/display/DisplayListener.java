package com.ruegnerlukas.simpleutils.display;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public interface DisplayListener {

	public void onCreate();
	
	public void onDraw(Graphics2D g, JPanel panel);
	
	public void onExit();
	
}

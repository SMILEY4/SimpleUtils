package com.ruegnerlukas.simpleutils.display;

import java.util.ArrayList;
import java.util.List;

public class DisplayConfig {

	public String title = "Display";
	public int width = 500;
	public int height = 400;
	public boolean decorated = true;
	
	public boolean exitWithEscape = true;
	
	public List<DisplayListener> listeners = new ArrayList<DisplayListener>();
	
	
}

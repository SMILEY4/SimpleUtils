package com.ruegnerlukas.simpleutils.color;




public class ColorUtils {

	
	
	
	
	
	/**
	 * generates given amount of colors (by taking equdistant colors in HSV-space)
	 * @param numColors	the amount of colors
	 * @return the array of generated colors
	 * */
	public static Colorf[] genEquidistantHSV(int numColors) {
		Colorf[] colors = new Colorf[numColors];
		for(int i=0; i<numColors; i++) {
			colors[i] = HSVtoRGB(((1f/(float)numColors)*i)*360f, 0.5f, 1.0f);
		}
		return colors;
	}
	
	
	
	
	/**
	 * generates given amount of colors (golden ratio)
	 * @param numColors	the amount of colors
	 * @return the array of generated colors
	 * */
	public static Colorf[] genGoldenRatio(int numColors) {
		Colorf[] colors = new Colorf[numColors];
		for(int i=0; i<numColors; i++) {
			float h = (i * 0.618033988749895f) % 1.0f;
			colors[i] = HSVtoRGB(h*360f, 0.5f, 1.0f);
		}
		return colors;
	}

	
	
	
	/**
	 * generates given amount of colors (golden ratio squared)
	 * @param numColors	the amount of colors
	 * @return the array of generated colors
	 * */
	public static Colorf[] genGoldenRatioSqrt(int numColors) {
		Colorf[] colors = new Colorf[numColors];
		for(int i=0; i<numColors; i++) {
			float h = (i * 0.618033988749895f) % 1.0f;
			colors[i] = HSVtoRGB(h*360f, 0.5f, (float)Math.sqrt(1f-((i*0.618033988749895f % 0.5f))));
		}
		return colors;
	}

	
	
	
	/**
	 * converts HSV to Color (RGB)
	 * @param h		the hue of the color (0-360)
	 * @param s		the saturation of the color (0-1)
	 * @param v		the value of the color (0-1)
	 * */
	public static Colorf HSVtoRGB(float h, float s, float v) {
		float r, g, b;
		int i;
		float f, p, q, t;
	 
		// Make sure our arguments stay in-range
		h = Math.max(0, Math.min(360, h));
		s = Math.max(0, Math.min(100, s));
		v = Math.max(0, Math.min(100, v));
	 
		
		if(s == 0) {
			// Achromatic (grey)
			r = g = b = v;
			return new Colorf(r, g, b, 1f);
		}
	 
		h /= 60; // sector 0 to 5
		i = (int) Math.floor(h);
		f = h - i; // factorial part of h
		p = v * (1 - s);
		q = v * (1 - s * f);
		t = v * (1 - s * (1 - f));
	 
		switch(i) {
			case 0:
				r = v;
				g = t;
				b = p;
				break;
	 
			case 1:
				r = q;
				g = v;
				b = p;
				break;
	 
			case 2:
				r = p;
				g = v;
				b = t;
				break;
	 
			case 3:
				r = p;
				g = q;
				b = v;
				break;
	 
			case 4:
				r = t;
				g = p;
				b = v;
				break;
	 
			default: // case 5:
				r = v;
				g = p;
				b = q;
		}
	 
		return new Colorf(r, g, b, 1f);
	}
	
	
}
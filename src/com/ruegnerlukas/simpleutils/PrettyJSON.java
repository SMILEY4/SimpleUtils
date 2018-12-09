package com.ruegnerlukas.simpleutils;

import java.util.ArrayList;
import java.util.List;

public class PrettyJSON {
	
	
	public static String pretty(String input) {
		String str = input.replace("\n", "").replaceAll("\r", "").replaceAll("\\s+(?=([^\"]*\"[^\"]*\")*[^\"]*$)", "");
		
		List<String> lines = new ArrayList<String>();
		List<Integer> levels = new ArrayList<Integer>();
		
		
		String currLine = "";
		int currLevel = 0;
		
		int n = 0;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(n%2 == 0) {
				if(c == '{' || c == '[') {
					lines.add(currLine + c);
					levels.add(currLevel);
					currLevel++;
					currLine = "";
					continue;
				}
				if(c == '}' || c == ']') {
					lines.add(currLine);
					levels.add(currLevel);
					currLevel--;
					currLine = ""+c;
					continue;
				}
				if(c == ',') {
					lines.add(currLine + c);
					levels.add(currLevel);
					currLine = "";
					continue;
				}
				if(c == ':') {
					currLine += ": ";
					continue;
				}
				
			}
			
			if(c == '"') {
				n++;
			}
			
			currLine += c;
			
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<lines.size(); i++) {
			
			int level = levels.get(i);
			for(int j=0; j<level; j++) {
				sb.append("    ");
			}

			String line = lines.get(i);
			sb.append(line);
			sb.append(System.lineSeparator());
			
		}
		
		return sb.toString();
	}
	
	
}

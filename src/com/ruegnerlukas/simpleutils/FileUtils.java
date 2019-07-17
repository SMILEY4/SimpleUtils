package com.ruegnerlukas.simpleutils;

import java.io.*;

public class FileUtils {


	private FileUtils() {
	}




	/**
	 * load a file; used for files, which are inside the jar
	 *
	 * @param path the path to the file
	 * @return the InputStream
	 */
	public static InputStream loadFileStream(String path) {
		return FileUtils.class.getClassLoader().getResourceAsStream(path);
	}




	/**
	 * load a file; used for files, which are in the same directory as the jar
	 *
	 * @param path the path to the file
	 * @return the file
	 */
	public static File loadFile(String path) {
		File file = null;
		String pathToFile = JarLocation.getJarLocation() + "/" + path;
		file = new File(pathToFile);
		return file;
	}




	/**
	 * reads the content of a text file
	 *
	 * @param file                the text file
	 * @param appendLineSeperator whether or not line breaks should be added to the final string
	 * @return the content as String
	 */
	public static String getTextContent(File file, boolean appendLineSeperator) {
		String fileContent = "";

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				if (appendLineSeperator) sb.append(System.lineSeparator());
				line = br.readLine();
			}
			fileContent = sb.toString();
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileContent;
	}


}

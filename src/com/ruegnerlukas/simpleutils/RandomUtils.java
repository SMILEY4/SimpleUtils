package com.ruegnerlukas.simpleutils;

import java.util.Random;

public class RandomUtils {


	public static String generateRandomHexString(int length) {
		return generateRandomHexString(length, new Random().nextLong());
	}




	public static String generateRandomHexString(int length, long seed) {

		StringBuilder builder = new StringBuilder();
		Random random = new Random(seed);

		for (int i = 0; i < length; i++) {

			/*

			  48 = 0
			  ...
			  57 = 9

			  97 = a
			  ...
			 122 = z

			 */
			int bucket = random.nextInt(2);

			if (bucket == 0) {
				builder.append((char) (random.nextInt(10) + 48));
			}
			if (bucket == 1) {
				builder.append((char) (random.nextInt(6) + 97));
			}

		}

		return builder.toString();
	}




	public static String generateRandomString(int length) {
		return generateRandomString(length, new Random().nextLong());
	}




	public static String generateRandomString(int length, long seed) {

		StringBuilder builder = new StringBuilder();
		Random random = new Random(seed);

		for (int i = 0; i < length; i++) {

			int bucket = random.nextInt(3);

			if (bucket == 0) {
				builder.append((char) (random.nextInt(10) + 48));
			}
			if (bucket == 1) {
				builder.append((char) (random.nextInt(26) + 65));
			}
			if (bucket == 2) {
				builder.append((char) (random.nextInt(26) + 97));
			}

		}

		return builder.toString();
	}


}

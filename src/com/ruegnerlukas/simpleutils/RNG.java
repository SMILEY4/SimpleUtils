package com.ruegnerlukas.simpleutils;

import java.util.Random;

public class RNG {


	private static Random rand = new Random();
	private static Random randomSeeded = new Random();




	private RNG() {
	}




	/**
	 * @return a random number (int)
	 */
	public static int random() {
		return rand.nextInt();
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (int)
	 */
	public static int random(long seed) {
		randomSeeded.setSeed(seed);
		return randomSeeded.nextInt();
	}




	/**
	 * @return a random number (int) between 0 (inclusive) and "range" (inclusive)
	 */
	public static int random(int range) {
		return rand.nextInt(range + 1);
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (int) between 0 (inclusive) and "range" (inclusive)
	 */
	public static int random(int range, long seed) {
		randomSeeded.setSeed(seed);
		return randomSeeded.nextInt(range + 1);
	}




	/**
	 * @return a random number (int) between "start" (inclusive) and "end" (inclusive)
	 */
	public static int random(int start, int end) {
		return start + rand.nextInt(end - start + 1);
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (int) between "start" (inclusive) and "end" (inclusive)
	 */
	public static int random(int start, int end, long seed) {
		randomSeeded.setSeed(seed);
		return start + randomSeeded.nextInt(end - start + 1);
	}




	/**
	 * @return a random number (float)
	 */
	public static float randomF() {
		return rand.nextFloat();
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (float)
	 */
	public static float randomF(long seed) {
		randomSeeded.setSeed(seed);
		return randomSeeded.nextFloat();
	}




	/**
	 * @return a random number (float) between 0 (inclusive) and "range" (inclusive)
	 */
	public static float randomF(float range) {
		return rand.nextFloat() * range;
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (float) between 0 (inclusive) and "range" (inclusive)
	 */
	public static float randomF(float range, long seed) {
		randomSeeded.setSeed(seed);
		return randomSeeded.nextFloat() * range;
	}




	/**
	 * @return a random number (float) between "start" (inclusive) and "end" (inclusive)
	 */
	public static float randomF(float start, float end) {
		return start + rand.nextFloat() * (end - start + 1);
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (float) between "start" (inclusive) and "end" (inclusive)
	 */
	public static float randomF(float start, float end, long seed) {
		randomSeeded.setSeed(seed);
		return start + randomSeeded.nextFloat() * (end - start + 1);
	}




	/**
	 * @return a random number (double)
	 */
	public static double randomD() {
		return rand.nextDouble();
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (double)
	 */
	public static double randomD(long seed) {
		randomSeeded.setSeed(seed);
		return randomSeeded.nextDouble();
	}




	/**
	 * @return a random number (double) between 0 (inclusive) and "range" (inclusive)
	 */
	public static double randomD(double range) {
		return rand.nextDouble() * range;
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (double) between 0 (inclusive) and "range" (inclusive)
	 */
	public static double randomD(double range, long seed) {
		randomSeeded.setSeed(seed);
		return randomSeeded.nextDouble() * range;
	}




	/**
	 * @return a random number (double) between "start" (inclusive) and "end" (inclusive)
	 */
	public static double randomD(double start, double end) {
		return start + rand.nextDouble() * (end - start + 1);
	}




	/**
	 * @param seed the seed for the random number
	 * @return a random number (double) between "start" (inclusive) and "end" (inclusive)
	 */
	public static double randomD(double start, double end, long seed) {
		randomSeeded.setSeed(seed);
		return start + randomSeeded.nextDouble() * (end - start + 1);
	}


}

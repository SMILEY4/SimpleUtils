package com.ruegnerlukas.simpleutils.arrays;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {


	public static <T> boolean contains(T[] array, T value) {
		for (T t : array) {
			if (t.equals(value)) {
				return true;
			}
		}
		return false;
	}




	/**
	 * Removes an element at the given index from the given list by replacing it with the last element.
	 * This avoids System.copy but destroys the order of the elements in the list
	 */
	public static void switchRemove(List list, int index) {
		if (list.isEmpty()) {
			return;
		}
		if (index >= 0 && index < list.size()) {
			if (list.size() == 1 || index == list.size() - 1) {
				list.remove(index);
			} else {
				list.set(index, list.get(list.size() - 1));
				list.remove(list.size() - 1);
			}

		} else {
			throw new InvalidParameterException("Given index out of bounds: index=" + index + " size=" + list.size());
		}
	}




	public static void applyPermutation(List list, int[] permutations, int offset) {
		int[] p = new int[list.size()];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
		for (int i = 0; i < permutations.length; i++) {
			p[i + offset] = permutations[i] + offset;
		}
		applyPermutation(list, p);
	}




	public static void applyPermutation(List list, int[] permutations) {
		if (permutations.length != list.size()) {
			throw new IllegalArgumentException();
		}
		Object[] array = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[permutations[i]] = list.get(i);
		}
		list.clear();
		list.addAll(Arrays.asList(array));
	}




	public static boolean moveElement(List list, Object obj, boolean movePositive) {
		return moveElement(list, list.indexOf(obj), movePositive);
	}




	public static boolean moveElement(List list, int index, boolean movePositive) {
		if (0 > index || index >= list.size()) {
			return false;
		}
		int indexDst = index + (movePositive ? +1 : -1);
		if (0 <= indexDst && indexDst <= list.size()) {
			Object obj = list.remove(index);
			list.add(indexDst, obj);
			return true;
		} else {
			return false;
		}
	}

}

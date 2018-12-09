package com.ruegnerlukas.simpleutils.arrays;

import java.security.InvalidParameterException;
import java.util.List;

public class ArrayUtils {

	/**
	 * Removes an element at the given index from the given list by replacing it with the last element.
	 * This avoids System.copy but destroys the order of the elements in the list
	 * */
	public static void switchRemove(List list, int index) {
		if(list.isEmpty()) {
			return;
		}
		if(index >= 0 && index < list.size()) {
			if(list.size() == 1 || index == list.size()-1) {
				list.remove(index);
			} else {
				list.set(index, list.get(list.size()-1));
				list.remove(list.size()-1);
			}
			
		} else {
			throw new InvalidParameterException("Given index out of bounds: index=" + index + " size=" + list.size());
		}
	}
	
}

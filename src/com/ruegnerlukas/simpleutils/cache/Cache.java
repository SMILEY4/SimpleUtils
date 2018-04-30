package com.ruegnerlukas.simpleutils.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Cache<K,V> implements ICache<K,V> {

	
	private int maxSize;
	private int size = 0;
	
	private HashMap<K,V> map;

	private List<K> keys; 	// list of all keys. Latest objects in back, oldest objects at beginning
	private List<V> values; // unsorted list of all values

	
	
	
	
	
	public Cache(int maxSize) {
		this.maxSize = maxSize;
		this.map = new HashMap<K,V>();
		this.keys = new LinkedList<K>();
		this.values = new LinkedList<V>();
	}
	
	
	
	
	
	
	@Override
	public void put(K key, V value) {
		if(key == null) {
			throw new IllegalArgumentException("Invalid Key.");
		}
		if(value == null) {
			throw new IllegalArgumentException("Invalid Value.");
		}

		if(map.containsKey(key)) {
			map.put(key, value);
			keys.remove(key);
			keys.add(key);
			values.add(value);
			size++;
			
		} else {
			if(size == maxSize) {
				K keyToRemove = keys.get(0);
				V valToRemove = map.get(keyToRemove);
				keys.remove(0);
				values.remove(valToRemove);
				size--;
			}
			
			map.put(key, value);
			keys.add(key);
			values.add(value);
			size++;
		}
		
		
	}

	
	
	
	@Override
	public V get(K key) {
		V value = map.get(key);
		if(value != null) {
			keys.remove(key);
			keys.add(key);
		}
		return value;
	}

	
	
	
	@Override
	public V remove(K key) {
		V value = map.remove(key);
		if(value != null) {
			values.remove(value);
			keys.remove(key);
			size--;
		}
		return value;
	}

	
	
	
	@Override
	public int size() {
		return this.size;
	}

	
	
	
	@Override
	public int maxSize() {
		return this.maxSize;
	}
	
	
	
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	
	
	
	@Override
	public void clear() {
		map.clear();
		values.clear();
		keys.clear();
		size = 0;
	}
	
	
	

	@Override
	public boolean containsKey(K key) {
		return map.containsKey(key);
	}

	
	
	
	@Override
	public boolean containsValue(V value) {
		return map.containsValue(value);
	}

	
	
	
	@Override
	public List<K> getKeys() {
		return Collections.unmodifiableList(keys);
	}

	
	
	
	@Override
	public List<V> getValues() {
		return Collections.unmodifiableList(values);
	}


}

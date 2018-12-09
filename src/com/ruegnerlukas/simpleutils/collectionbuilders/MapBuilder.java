package com.ruegnerlukas.simpleutils.collectionbuilders;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K,V> {

	
	private Map<K,V> map = new HashMap<K,V>();
	
	
	
	
	public MapBuilder<K,V> add(K key, V value) {
		if(value == null) {
			this.map.remove(key);
		} else {
			this.map.put(key, value);
		}
		return this;
	}
	
	
	
	
	public MapBuilder<K,V> add(Map<K,V> map) {
		this.map.putAll(map);
		return this;
	}
	
	
	
	
	public Map<K,V> get() {
		return this.map;
	}
	
	
}


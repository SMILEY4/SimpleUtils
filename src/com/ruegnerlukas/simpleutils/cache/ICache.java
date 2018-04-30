package com.ruegnerlukas.simpleutils.cache;

import java.util.List;

public interface ICache<K,V> {

	
	/**
	 * Inserts an entry into the cache. If the maximum size of the cache is reached, the oldest entry will be removed.
	 * */
	public void put(K key, V value);
	
	
	/**
	 * @return the value associated with the given key
	 * */
	public V get(K key);
	
	
	/**
	 * Removes the entry with the given key
	 * @return the removed value
	 * */
	public V remove(K key);
	
	
	/**
	 * @return the number of entries in this cache
	 * */
	public int size();
	
	
	/**
	 * @return the maximum size of this cache
	 * */
	public int maxSize();
	
	
	/**
	 * @return true, if this cache does not contain any objects
	 * */
	public boolean isEmpty();

	
	/**
	 * Removes all objects from this cache
	 * */
	public void clear();
	
	
	/**
	 * @return true, if this cache contains the given key
	 * */
	public boolean containsKey(K key);
	
	
	/**
	 * @return true, if this cache contains the given value
	 * */
	public boolean containsValue(V value);


	/**
	 * @return a unmodifiable list containing all keys
	 * */
	public List<K> getKeys();
	
	
	/**
	 * @return a unmodifiable list containing all values
	 * */
	public List<V> getValues();
	
}

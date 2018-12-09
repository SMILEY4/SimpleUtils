package com.ruegnerlukas.simpleutils.collectionbuilders;

import java.util.Collection;
import java.util.LinkedList;

public 	class LinkedListBuilder<V> extends ListBuilder<V> {
	
	private LinkedList<V> list = new LinkedList<V>();
	
	
	@Override
	public ListBuilder<V> add(V value) {
		list.add(value);
		return this;
	}
	
	
	@Override
	public ListBuilder<V> add(V... values) {
		for(int i=0; i<values.length; i++) {
			add(values[i]);
		}
		return this;
	}
	
	
	@Override
	public ListBuilder<V> add(Collection<V> values) {
		list.addAll(values);
		return this;
	}
	
	
	@Override
	public LinkedList<V> get() {
		return this.list;
	}
	
}
package com.ruegnerlukas.simpleutils.collectionbuilders;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListBuilder<V> extends ListBuilder<V> {
	
	private ArrayList<V> list = new ArrayList<V>();
	
	
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
	public ArrayList<V> get() {
		return this.list;
	}
	
}

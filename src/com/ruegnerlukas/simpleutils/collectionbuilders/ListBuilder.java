package com.ruegnerlukas.simpleutils.collectionbuilders;

import java.util.Collection;
import java.util.List;

public abstract class ListBuilder<V> {

	public abstract ListBuilder<V> add(V value);
	
	public abstract ListBuilder<V> add(V... values);
	
	public abstract ListBuilder<V> add(Collection<V> list);
	
	public abstract List<V> get();
	
}




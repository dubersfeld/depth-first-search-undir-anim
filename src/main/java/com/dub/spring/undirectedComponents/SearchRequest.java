package com.dub.spring.undirectedComponents;

/** used in AJAX request */
public class SearchRequest {
	private Type type;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	enum Type {
		INIT, STEP, COLLECTION
	}
}

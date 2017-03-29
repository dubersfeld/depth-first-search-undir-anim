package com.dub.site.undirectedComponents;

public class Edge {
	
	/** This class represents an undirected edge
	 */ 
	private int to;
			
	public Edge(int to) {
		this.to = to;
	}
	
	public Edge(Edge source) {
		this.to = source.to;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}		
	

	public String toString() {
		return "" + to;
	}
	
}

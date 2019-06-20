package com.dub.spring.undirectedComponents;

/** Encapsulation of an adjacency list with weights */
public class JSONAdjacency {
	
	private Edge[] adjacency;
	
	public JSONAdjacency(int N) {
		this.adjacency = new Edge[N];
	}
	
	

	public Edge[] getAdjacency() {
		return adjacency;
	}

	public void setAdjacency(Edge[] adjacency) {
		this.adjacency = adjacency;
	}
	
	
	// for debugging only
	public void display() {
		for (int i = 0; i < this.adjacency.length; i++) {
			System.out.println(this.adjacency[i]);
		}
	}
	
}

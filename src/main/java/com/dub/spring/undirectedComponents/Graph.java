package com.dub.spring.undirectedComponents;

import java.io.Serializable;


/** Graph represents a weighted undirected graph. 
 * It has vertices and adjacency lists that are represented by a custom class SimpleList 
 * that partially implements the interface List (only used methods are implemented) 
 * */
public class Graph implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Vertex[] vertices;
	protected int N;
	
	public Graph(int N) {
		vertices = new Vertex[N];
		this.N = N;
	}
	
	public Vertex[] getVertices() {
		return vertices;
	}
	public void setVertices(Vertex[] vertices) {
		this.vertices = vertices;
	}
	

	public void display() {// used for debugging only
		System.out.println("Graph.display");
		for (int i1 = 0; i1 < N; i1++) {
			System.out.println(vertices[i1].getName());
		}
		System.out.println();
	}
	
	public void display2() {// used for debugging only
		System.out.println("Graph.display2");
		for (int i1 = 0; i1 < N; i1++) {// for each vertex
			System.out.print(vertices[i1].getName() + " -> ");
			for (int i2 = 0; i2 < vertices[i1].getAdjacency().size(); i2++) {
				int lind = this.vertices[i1].getAdjacency().get(i2).getTo();
				System.out.print(this.vertices[lind].getName() + " ");
			}
			System.out.println();
		}
		System.out.println();	
	}// display2	
	
	public final void display3() {// used for debugging only
		System.out.println("Graph.display3");
		for (int i1 = 0; i1 < N; i1++) {// for each vertex
			System.out.print(i1 + " -> ");
			for (int k = 0; k < vertices[i1].getAdjacency().size(); k++) {
				int lind = this.vertices[i1].getAdjacency().get(k).getTo();
				System.out.print(lind + " ");
			}
			System.out.println();
		}
		System.out.println();	
	}// display2	
	

	
}

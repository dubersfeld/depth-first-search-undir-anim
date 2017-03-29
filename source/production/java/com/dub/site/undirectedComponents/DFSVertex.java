package com.dub.site.undirectedComponents;


public class DFSVertex extends Vertex {

	/**
	 * DFSVertex subclasses DisplayVertex for DFSSearch.
	 * It contains all additional fields specific to Depth First Search
	 */
	    
	private Color color = Color.BLACK;
	private int d = 0;
	private int f = 0;
	private int comp = 0;
	
	public DFSVertex() {
		super();
		
	}
	
	public DFSVertex(DFSVertex source) {
		super(source);
		this.color = source.color;
		this.d = source.d;
		this.f = source.f;
		this.comp = source.comp;
	}
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}

	public String toString() {
		return name + " "
				+ " " + color + " " + d + "/" + f + " " + comp;
	}

	public static enum Color {
		BLACK, GREEN, BLUE
	}

}

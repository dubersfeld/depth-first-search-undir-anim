package com.dub.spring.undirectedComponents;

import com.dub.spring.undirectedComponents.DFSVertex.Color;

/** POJO represents vertex in AJAX messages */
public class JSONVertex {
	
	/**
	 * 
	 */
	private String name;
	private Color color = Color.BLACK;
	private int d = 0;
	private int f = 0;
	private int comp = 0;
	
	public JSONVertex() {
	}
	
	public JSONVertex(DFSVertex source) {
		this.name = source.getName();
		this.color = source.getColor();
		this.d = source.getD();
		this.f = source.getF();
		this.comp = source.getComp();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

}

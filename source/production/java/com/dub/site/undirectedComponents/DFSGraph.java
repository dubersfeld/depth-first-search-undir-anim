package com.dub.site.undirectedComponents;

import java.util.List;

import com.dub.util.SimpleStack;
import com.fasterxml.jackson.annotation.JsonIgnore;


/** Graph has Vertices and Adjacency Lists */
public class DFSGraph extends Graph {
	
	/**
	 * This subclass of Graph implements a Depth First Search algorithm on an undirected graph
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private SimpleStack<Integer> stack;// here SimpleStack is a custom Stack implementation
	
	private int N;
	private int lastFound = 0;
	private int compNumber = 0;
	private boolean finished = false;
	
	private Integer index;// main search loop current index
		
	int time = 0;
	
	
	public DFSGraph(int N) {
		super(N);
		this.N = N;
		stack = new SimpleStack<>();
		index = 0;
		compNumber = 0;
	}
	
	public DFSGraph(DFSGraph source) {// deep copy c'tor
		super(source.N);
		this.stack = new SimpleStack<>();
		for (int i = 0; i < source.N; i++) {
			DFSVertex dfsVertex = (DFSVertex)source.getVertices()[i];
			this.getVertices()[i] = new DFSVertex(dfsVertex);
		}
	}
	
	
	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public SimpleStack<Integer> getStack() {
		return stack;
	}

	public void setStack(SimpleStack<Integer> stack) {
		this.stack = stack;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public void searchStep() {
		/** one vertex is visited at each step */
	
		finished = false;
			
		DFSVertex u = (DFSVertex)this.vertices[index];
		
		// begin with coloring
		if (u.getColor().equals(DFSVertex.Color.BLACK)) {// vertex has just been discovered
			u.setColor(DFSVertex.Color.GREEN);// visited
			time++;
			u.setD(time);
			u.setComp(compNumber);
		}
			
		List<Edge> conn = u.getAdjacency();// present vertex successors 
		
	    Integer first = null;// first successor index if present
	    boolean finish = false;
	    
	    if (conn.isEmpty() || (first = this.findNotVisitedAndMark(conn, index)) == null) {
	    	finish = true;
	    }
	       
	    if (!finish) {// prepare to descend
	         
	        stack.push(index);// push present vertex before descending 	
	        index = first;// save u for the next step
	        
	    } else {// finish present vertex
	    	u.setColor(DFSVertex.Color.BLUE);
	    	time++;
	    	u.setF(time);
	    	if (!stack.isEmpty()) {
	    		index = stack.pop(); 	
	    	} else {
	    		index = this.findNotVisited();// can be null
	    		if (index != null) {
	    			compNumber++;// begin new Comp
	    		} else {	    		
	    			System.out.println("searchStep FINISHED");
	    			finished = true;
	    		}	
	    	}
	    }

	}// searchStep
			
	
	// look for a non visited vertex to begin a new component
	public Integer findNotVisited() {
		int nind = 0;
		DFSVertex v = null;
		for (nind = this.lastFound + 1; nind < N; nind++) {
			v = (DFSVertex)this.vertices[nind];
			if (v.getColor().equals(DFSVertex.Color.BLACK)) {
				break;
			}
		}
		
		if (nind < N) {
			this.lastFound = nind;// save as initial value for next lookup 
		
			return nind;
		} else {
			return null;
		}
				
	}// findNotVisited
	
	
	public Integer findNotVisitedAndMark(List<Edge> list, int from) {
		// successor lookup		
		int nind = 0;
		DFSVertex v = null;
		
		for (nind = 0; nind < list.size(); nind++) {
			int to = list.get(nind).getTo();
			v = (DFSVertex)this.vertices[to];
	 		
			if (v.getColor().equals(DFSVertex.Color.BLACK)) {
				break;
			}
		}
		if (nind < list.size()) {
			return list.get(nind).getTo();
		} else {
			return null;
		}
		
	}// findNotVisited
	
	public void displayDFS() {
		for (int i1 = 0; i1 < N; i1++) {
			System.out.println((DFSVertex)vertices[i1]);
		}
	}
	
}

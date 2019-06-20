package com.dub.spring.undirectedComponents;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GraphServices {
	
	public DFSGraph jsonToDFS(
						List<JSONEdge> jsonEdges,
						List<JSONVertex> jsonVertices) {
	
		DFSGraph graph = new DFSGraph(jsonVertices.size());
		
		for (int i = 0; i < jsonVertices.size(); i++) {
			DFSVertex v = new DFSVertex();
			v.setName(jsonVertices.get(i).getName());
			v.setColor(DFSVertex.Color.BLACK);
			graph.getVertices()[i] = v;
		}
		
		for (int i = 0; i < jsonEdges.size(); i++) {
			int from = jsonEdges.get(i).getFrom();
			int to = jsonEdges.get(i).getTo();
			Vertex v1 = graph.getVertices()[from];
			//Vertex v2 = graph.getVertices().get(to);
			v1.getAdjacency().add(new Edge(to));
		}
		
		return graph;
	}// jsonToDFS
	
	public JSONSnapshot dfsToJSON(DFSGraph graph) {
		int N = graph.getVertices().length;
		
		JSONSnapshot snapshot = new JSONSnapshot(N); 
			
		for (int i = 0; i < N; i++) {
			snapshot.getVertices()[i] 
					= new JSONVertex((DFSVertex)graph.getVertices()[i]);
		}
			
		// no weight involved here
		for (int i = 0; i < N; i++) {// for each vertex
			List<Edge> adjacency = graph.getVertices()[i].getAdjacency();
			int Nadj = adjacency.size();
			JSONAdjacency enclume = new JSONAdjacency(Nadj);
			
			for (int k = 0; k < Nadj; k++) {
				enclume.getAdjacency()[k] 
						= new Edge(adjacency.get(k));
			}
			
			snapshot.getAdjacencies()[i] = enclume;
			
		}
				
		return snapshot;
	}

}

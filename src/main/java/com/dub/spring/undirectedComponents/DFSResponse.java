package com.dub.spring.undirectedComponents;

import java.util.List;

/** container object for Ajax response 
 * contains snapshots of the graph created by the DFS loop 
 **/
public class DFSResponse {
	private Status status;
	private List<JSONSnapshot> snapshots;
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<JSONSnapshot> getSnapshots() {
		return snapshots;
	}

	public void setSnapshots(List<JSONSnapshot> snapshots) {
		this.snapshots = snapshots;
	}






	public static enum Status {
		OK, ERROR
	}
}

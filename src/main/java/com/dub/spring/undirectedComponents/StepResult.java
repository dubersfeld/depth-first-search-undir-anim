package com.dub.spring.undirectedComponents;

/** container for AJAX response */
public class StepResult {
	
	private Status status;
	private JSONSnapshot snapshot;
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public JSONSnapshot getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(JSONSnapshot snapshot) {
		this.snapshot = snapshot;
	}



	public enum Status {
		STEP, FINISHED, INIT
	}
}

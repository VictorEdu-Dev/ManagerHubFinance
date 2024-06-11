package org.vedu.managerhubfinance.persistence.repository;

public enum FetchDAO {
	LOAD_GRAPH("jakarta.persistence.loadgraph"), 
	FETCH_GRAPH("jakarta.persistence.fetchgraph");
	
	private String fetchGraph;
	
	FetchDAO(String fetchGraph) {
		this.fetchGraph = fetchGraph;
	}
	
	public String getTypeGraph() {
		return fetchGraph;
	}
}

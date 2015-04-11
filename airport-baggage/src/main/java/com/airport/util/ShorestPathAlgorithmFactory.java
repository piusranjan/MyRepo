package com.airport.util;

public class ShorestPathAlgorithmFactory{

	public static ShorestPathAlgorithm getInstance(Graph graph) {

		return new DijkstraAlgorithm(graph);	
		

	}

}

package com.airport.util;

import com.airport.util.Route;


public interface ShorestPathAlgorithm {
	
	public <I> Route<I> getShortestPath(Vertex source , Vertex destination);

}

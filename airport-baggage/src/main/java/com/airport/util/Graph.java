package com.airport.util;

import java.util.List;



/**
 * @author PSATPATH
 * 		   A graph is made out of nodes and directed edges which defines a
 *         connection from one node to another node.
 * 
 *         A node (or vertex) is a discrete position in a graph. Edges can be
 *         directed an undirected. Edges have an associated distance (also
 *         called costs or weight). The distance between two nodes a and b is
 *         labeled as [a,b].
 * 
 *         The mathematical description for graphs is G= {V,E}, meaning that a
 *         graph is defined by a set of vertexes (V) and a collection of edges.
 * 
 *         The order of a graph is the number of nodes. The size of a graph is
 *         the number of edges.
 * 
 *
 */
public class Graph {
	private final List<Vertex> vertexes;
	private final List<Edge> edges;

	private Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public static Graph getGraph(List<Vertex> vertexes, List<Edge> edges) {

		return new Graph(vertexes, edges);

	}
	
	@Override
	public String toString() {

		String graphvalues = "";
		for (Edge edge : this.edges) {

			graphvalues = graphvalues +""+ edge.getId()+" : "+ edge.getSource() + "------>"
					+ edge.getDestination() + " distance :" + edge.getWeight()+"\n";
		}

		return graphvalues;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result
				+ ((vertexes == null) ? 0 : vertexes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (vertexes == null) {
			if (other.vertexes != null)
				return false;
		} else if (!vertexes.equals(other.vertexes))
			return false;
		return true;
	}



}
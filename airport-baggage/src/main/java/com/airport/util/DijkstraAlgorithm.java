package com.airport.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author PSATPATH
 * 
 *        
 *         Typical graph problems are described in the following list.
 * 
 *         (a)finding the shortest path from a specific node to another node
 * 
 *         (b)finding the maximum possible flow through a network where each edges
 *         has a pre-defined maximum capacity (maximum-flow minimum-cut problem)
 * 
 *         
 *         The Dijkstra Algorithm finds the shortest path from a source to all
 *         destination in a directed graph (single source shortest path
 *         problem). 
 *         
 *         Dijkstra partitions all nodes into two distinct sets. Unsettled and
 *         settled. Initially all nodes are in the unsettled sets, e.g. they
 *         must be still evaluated. A node is moved to the settled set if a
 *         shortest path from the source to this node has been found.
 * 
 *         Initially the distance of each node to the source is set to a very
 *         high value.
 * 
 *         First only the source is in the set of unsettledNodes.
 * 
 *         The algorithms runs until the unsettledNodes are empty. In each
 *         iteration it selects the node with the lowest distance from the
 *         source out the unsettled nodes. If reads all edges which are outgoing
 *         from the source and evaluates for each destination node in these
 *         edges which is not yet settled if the known distance from the source
 *         to this node can be reduced if the selected edge is used. If this can
 *         be done then the distance is updated and the node is added to the
 *         nodes which need evaluation.
 * 
 *         
 */
public final class DijkstraAlgorithm implements ShorestPathAlgorithm {

	private final List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Integer> distance;

	public DijkstraAlgorithm(Graph graph) {
		// create a copy of the array so that we can operate on this array
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	public void execute(Vertex source) {
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Integer>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Vertex node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	private void findMinimalDistances(Vertex node) {
		List<Vertex> adjacentNodes = getNeighbors(node);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node)
					+ getDistance(node, target)) {
				distance.put(target,
						getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private int getDistance(Vertex node, Vertex target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(node)
					&& edge.getDestination().equals(target)) {
				return edge.getWeight();
			} else if (edge.getDestination().equals(node)
					&& edge.getSource().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node)
					&& !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			} else if (edge.getDestination().equals(node)
					&& !isSettled(edge.getSource())) {
				neighbors.add(edge.getSource());

			}
		}
		return neighbors;
	}

	private Vertex getMinimum(Set<Vertex> vertexes) {
		Vertex minimum = null;
		for (Vertex vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Vertex vertex) {
		return settledNodes.contains(vertex);
	}

	private int getShortestDistance(Vertex destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	private LinkedList<Vertex> getPath(Vertex target) {

		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

	@Override
	public <I> Route<I> getShortestPath(Vertex source, Vertex destination) {
		// TODO Auto-generated method stub
		LinkedList<Vertex> path;
		if (destination.equals(source)) {

			path = new LinkedList<Vertex>();
			path.add(source);
			return new Route<I>(path, 0);

		}

		this.execute(source);
		path = this.getPath(destination);
		return new Route<I>(path, distance.get(destination));
	}

}
package com.airport.util;

import java.util.List;
import java.util.Collections;

import com.airport.util.Vertex;


public class Route<I> {
	
	
	private final List<Vertex> nodes;

	private final int distance;
	private RoutingItem<I> routingItem;

	public Route(List<Vertex> nodes, int distance) {
		super();
		this.nodes = nodes;
		this.distance = distance;
	}

	

	public List<Vertex> getNodes() {
		return Collections.unmodifiableList(nodes);
	}

	public int getDistance() {
		return distance;
	}


	public RoutingItem<I> getRoutingItem() {
		return routingItem;
	}

	public void setRoutingItem(RoutingItem<I> routingItem) {
		this.routingItem = routingItem;
	}
	
	@Override
	public String toString() {
		return routingItem.getId() + " " + nodes + " :  " + distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distance;
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
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
		Route other = (Route) obj;
		if (distance != other.distance)
			return false;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}

}

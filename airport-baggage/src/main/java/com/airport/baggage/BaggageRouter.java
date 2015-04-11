package com.airport.baggage;

import com.airport.util.Graph;
import com.airport.util.RoutingItem;
import com.airport.util.Route;

import com.airport.util.ShorestPathAlgorithm;
import com.airport.util.ShorestPathAlgorithmFactory;

public class BaggageRouter implements Router {

	private final Graph graph;

	private BaggageRouter(Graph graph) {
		super();
		this.graph = graph;
	}

	public static Router getRouter(Graph graph) {

		return new BaggageRouter(graph);

	}

	@Override
	public Route<Baggage> route(RoutingItem<Baggage> routingItem) {

		ShorestPathAlgorithm shorestPathAlgorithm = ShorestPathAlgorithmFactory
				.getInstance(graph);
		Route<Baggage> baggageRoute = shorestPathAlgorithm.getShortestPath(
				routingItem.getSource(), routingItem.getDestination());
		baggageRoute.setRoutingItem(routingItem);
		return baggageRoute;
	}
}

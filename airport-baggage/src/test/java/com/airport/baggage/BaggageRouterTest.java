package com.airport.baggage;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.airport.util.Edge;
import com.airport.util.Graph;
import com.airport.util.Route;
import com.airport.util.RoutingItem;
import com.airport.baggage.Router;
import com.airport.util.Vertex;

public class BaggageRouterTest {

	private static final String CONCOURSE_A_TICKETING = "Concourse_A_Ticketing";
	private static final String BAGGAGECLAIM = "BaggageClaim";
	private static List<Vertex> nodes;
	private static List<Edge> paths;
	private static List<Flight> flights;
	private static Map<String, Vertex> nodeMap;
	private static Map<Flight, Vertex> flightToGateMap;
	private static Router router;
	private static Graph graph;
	private static Map<String, Flight> flightMap;
	private static Flight UA10, UA11, UA12, UA13, UA14, UA15, UA16, UA17, UA18;
	private static RoutingItem<Baggage> routingItem0001, routingItem0002,
			routingItem0003, routingItem0004, routingItem0005, routingItem0006;
	private static Route<Baggage> route001, route002, route003, route004,
			route005, route006;

	@BeforeClass
	public static void initialize() {

		intializeGate();
		initializeGraph();
		initializeFlight();
		initializeRouitingItem();
		router = BaggageRouter.getRouter(graph);
		routeItems();

	}

	public static void routeItems() {

		System.out
				.println("***************Optimal Path Start********************");
		route001 = router.route(routingItem0001);
		System.out.println(route001);
		route002 = router.route(routingItem0002);
		System.out.println(route002);
		route003 = router.route(routingItem0003);
		System.out.println(route003);
		route004 = router.route(routingItem0004);
		System.out.println(route004);
		route005 = router.route(routingItem0005);
		System.out.println(route005);
		route006 = router.route(routingItem0006);
		System.out.println(route006);
		System.out
				.println("***************Optimal Path End********************");

	}

	public static void initializeRouitingItem() {

		Baggage arrivalBag = Baggage.getInstance(null);

		routingItem0001 = RoutingItem.getInstance("001", nodeMap.get("A8"),
				flightToGateMap.get(flightMap.get("UA14")),
				Baggage.getInstance(UA14));
		routingItem0002 = RoutingItem.getInstance("002", nodeMap.get("A1"),
				flightToGateMap.get(flightMap.get("UA18")),
				Baggage.getInstance(UA18));
		routingItem0003 = RoutingItem.getInstance("003", nodeMap.get("A1"),
				flightToGateMap.get(flightMap.get("UA18")),
				Baggage.getInstance(UA18));
		routingItem0004 = RoutingItem.getInstance("004", nodeMap.get("A1"),
				flightToGateMap.get(flightMap.get("UA12")),
				Baggage.getInstance(UA18));
		routingItem0005 = RoutingItem.getInstance("005",
				nodeMap.get("Concourse_A_Ticketing"),
				flightToGateMap.get(flightMap.get("UA12")),
				Baggage.getInstance(UA18));

		routingItem0006 = RoutingItem.getInstance("006", nodeMap.get("A9"),
				nodeMap.get("BaggageClaim"), arrivalBag);

		System.out
				.println("*************Section: Bags Source and Destination Starts*************");

		System.out.println(routingItem0001 + "\n" + routingItem0001 + "\n"
				+ routingItem0002 + "\n" + routingItem0003 + "\n"
				+ routingItem0004 + "\n" + routingItem0005);
		System.out
				.println("*************Section: Bags Source and Destination Ends*************");
	}

	@Test
	public void getshotestRouteTestBagArrival() {

		List<Vertex> listNodes = new LinkedList<Vertex>();

		listNodes.add(Vertex.getVertex("A9", "A9"));

		listNodes.add(Vertex.getVertex("A10", "A10"));
		listNodes.add(Vertex.getVertex("A4", "A4"));
		listNodes.add(Vertex.getVertex("A3", "A3"));
		listNodes.add(Vertex.getVertex("A6", "A6"));
		listNodes.add(Vertex.getVertex("A5", "A5"));
		listNodes.add(Vertex.getVertex(BAGGAGECLAIM, BAGGAGECLAIM));
		assertEquals(11, route006.getDistance());
		assertEquals(listNodes, route006.getNodes());

		// System.out.println(route001);

	}

	@Test
	public void getshotestRouteTestBag001() {

		List<Vertex> listNodes = new LinkedList<Vertex>();

		listNodes.add(Vertex.getVertex("A8", "A8"));
		listNodes.add(Vertex.getVertex("A9", "A9"));
		listNodes.add(Vertex.getVertex("A10", "A10"));
		listNodes.add(Vertex.getVertex("A4", "A4"));
		listNodes.add(Vertex.getVertex("A3", "A3"));
		listNodes.add(Vertex.getVertex("A2", "A2"));
		assertEquals(6, route001.getDistance());
		assertEquals(listNodes, route001.getNodes());

		// System.out.println(route001);

	}

	@Test
	public void getshotestRouteTestFromConcourse() {

		List<Vertex> listNodes = new LinkedList<Vertex>();

		listNodes.add(Vertex.getVertex(CONCOURSE_A_TICKETING,
				CONCOURSE_A_TICKETING));
		listNodes.add(Vertex.getVertex("A5", "A5"));
		listNodes.add(Vertex.getVertex("A6", "A6"));
		listNodes.add(Vertex.getVertex("A3", "A3"));
		listNodes.add(Vertex.getVertex("A2", "A2"));
		listNodes.add(Vertex.getVertex("A1", "A1"));
		assertEquals(9, route005.getDistance());
		assertEquals(listNodes, route005.getNodes());

		// System.out.println(route001);

	}

	@Test
	public void getshotestRouteTestForSameGate() {

		List<Vertex> listNodes = new LinkedList<Vertex>();
		listNodes.add(Vertex.getVertex("A1", "A1"));
		assertEquals(0, route004.getDistance());
		assertEquals(listNodes, route004.getNodes());

		// System.out.println(route001);

	}

	private static void initializeGraph() {

		paths = new ArrayList<Edge>();

		addLane("Edge_0", nodeMap.get("Concourse_A_Ticketing"),
				nodeMap.get("A5"), 5);
		addLane("Edge_1", nodeMap.get("A5"), nodeMap.get("BaggageClaim"), 5);
		addLane("Edge_2", nodeMap.get("A4"), nodeMap.get("A10"), 2);
		addLane("Edge_3", nodeMap.get("A5"), nodeMap.get("A1"), 6);
		addLane("Edge_4", nodeMap.get("A1"), nodeMap.get("A2"), 1);
		addLane("Edge_5", nodeMap.get("A2"), nodeMap.get("A3"), 1);
		addLane("Edge_6", nodeMap.get("A3"), nodeMap.get("A4"), 1);
		addLane("Edge_7", nodeMap.get("A10"), nodeMap.get("A9"), 1);
		addLane("Edge_8", nodeMap.get("A9"), nodeMap.get("A8"), 1);
		addLane("Edge_9", nodeMap.get("A8"), nodeMap.get("A7"), 1);
		addLane("Edge_10", nodeMap.get("A7"), nodeMap.get("A6"), 4);
		addLane("Edge_11", nodeMap.get("A4"), nodeMap.get("A5"), 8);
		addLane("Edge_12", nodeMap.get("A3"), nodeMap.get("A6"), 1);
		addLane("Edge_13", nodeMap.get("A6"), nodeMap.get("A5"), 1);
		graph = Graph.getGraph(nodes, paths);
		System.out.println("************graph Start*************************");
		System.out.println(graph);
		System.out.println("************graph End*************************");

	}

	private static void addLane(String laneId, Vertex sourceNode,
			Vertex destNode, int distance) {
		Edge lane = new Edge(laneId, sourceNode, destNode, distance);
		paths.add(lane);
	}

	private static void initializeFlight() {

		flights = new ArrayList<Flight>();
		UA10 = Flight.getFlight("UA10", "MIA");
		UA11 = Flight.getFlight("UA11", "LAX");
		UA12 = Flight.getFlight("UA12", "JFK");
		UA13 = Flight.getFlight("UA13", "JFK");
		UA14 = Flight.getFlight("UA14", "JFK");
		UA15 = Flight.getFlight("UA15", "JFK");
		UA16 = Flight.getFlight("UA16", "JFK");
		UA17 = Flight.getFlight("UA17", "JFK");
		UA18 = Flight.getFlight("UA18", "JFK");
		flights.add(UA10);
		flights.add(UA11);
		flights.add(UA12);
		flights.add(UA13);
		flights.add(UA14);
		flights.add(UA15);
		flights.add(UA16);
		flights.add(UA17);
		flights.add(UA18);
		flightMap = new HashMap<String, Flight>();
		flightMap.put("UA10", UA10);
		flightMap.put("UA11", UA11);
		flightMap.put("UA12", UA12);
		flightMap.put("UA13", UA13);
		flightMap.put("UA14", UA14);
		flightMap.put("UA15", UA15);
		flightMap.put("UA16", UA16);
		flightMap.put("UA17", UA17);
		flightMap.put("UA18", UA18);

		flightToGateMap = new HashMap<Flight, Vertex>();

		flightToGateMap.put(UA10, nodeMap.get("A1"));
		flightToGateMap.put(UA11, nodeMap.get("A1"));
		flightToGateMap.put(UA12, nodeMap.get("A1"));
		flightToGateMap.put(UA13, nodeMap.get("A2"));
		flightToGateMap.put(UA14, nodeMap.get("A2"));
		flightToGateMap.put(UA15, nodeMap.get("A2"));
		flightToGateMap.put(UA16, nodeMap.get("A3"));
		flightToGateMap.put(UA17, nodeMap.get("A4"));
		flightToGateMap.put(UA18, nodeMap.get("A5"));

		Set<Map.Entry<Flight, Vertex>> entrySet = flightToGateMap.entrySet();

		System.out.println("**********Flight To Gate  Start--------");

		for (Entry<Flight, Vertex> entry : entrySet) {

			System.out.print("Flight =" + entry.getKey());
			System.out.println(" Gate =" + entry.getValue());

		}
		System.out.println("**********Flight To Gate  End--------");

	}

	private static void intializeGate() {
		nodes = new ArrayList<Vertex>();
		nodeMap = new HashMap<String, Vertex>();

		for (int i = 1; i < 11; i++) {

			Vertex v = Vertex.getVertex("A" + i, "A" + i);

			nodes.add(v);
			nodeMap.put("A" + i, v);
		}

		Vertex concourse_A_Ticketing = Vertex.getVertex(CONCOURSE_A_TICKETING,
				CONCOURSE_A_TICKETING);

		nodes.add(concourse_A_Ticketing);

		nodeMap.put("Concourse_A_Ticketing", concourse_A_Ticketing);

		Vertex baggageClaim = Vertex.getVertex(BAGGAGECLAIM, BAGGAGECLAIM);
		nodes.add(baggageClaim);
		nodeMap.put(BAGGAGECLAIM, baggageClaim);

	}

}

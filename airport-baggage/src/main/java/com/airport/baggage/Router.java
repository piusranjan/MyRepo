package com.airport.baggage;

import com.airport.baggage.Baggage;
import com.airport.util.Route;
import com.airport.util.RoutingItem;


public interface Router {
	
	public   Route<Baggage> route(RoutingItem<Baggage> routingItem);

}

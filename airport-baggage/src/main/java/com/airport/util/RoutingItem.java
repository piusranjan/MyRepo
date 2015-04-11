package com.airport.util;

/**
 * @author PSATPATH
 * 
 * @param <I>
 *            Routing Item is a generic Item meant for Routing.Routing Item can
 *            be a Bag or salesman or any other Item meant to route in the graph
 */
public class RoutingItem<I> {

	private final String id;
	private final Vertex source;
	private final Vertex destination;
	private I item;

	public String getId() {
		return id;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public RoutingItem(String id, Vertex source, Vertex destination, I item) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.item = item;
	}

	public I getItem() {
		return item;
	}

	public void setItem(I item) {
		this.item = item;
	}

	public RoutingItem(String id, Vertex source, Vertex destination) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
	}

	public static <I> RoutingItem<I> getInstance(String id, Vertex source,
			Vertex destination, I item) {

		return new RoutingItem<I>(id, source, destination, item);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		RoutingItem other = (RoutingItem) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoutingItem [id=" + id + ", source=" + source
				+ ", destination=" + destination + ", item=" + item + "]";
	}

}

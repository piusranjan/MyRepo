package com.airport.baggage;

public class Flight {

	private final String id;
	private final String destination;

	private Flight(String id, String destination) {
		super();
		this.id = id;
		this.destination = destination;
	}

	public static Flight getFlight(String id, String destination) {
		return new Flight(id, destination);

	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", destination=" + destination + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Flight other = (Flight) obj;
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
		return true;
	}

}
